package com.finance.common.aop;


import com.finance.common.Result;
import com.finance.common.annotation.FileTypeAnno;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 文件检查
 */
@Component
@Aspect
public class FileTypeAspect {

    @Pointcut("@annotation(com.finance.common.annotation.FileTypeAnno)")
    public void checkFileType(){}

    /**
     * 检查是否是注解里的文件类型
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "checkFileType()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        FileTypeAnno annotation = signature.getMethod().getAnnotation(FileTypeAnno.class);
        Set<String> includes = Arrays.stream(annotation.includes()).collect(Collectors.toSet());
        Set<String> excludes = Arrays.stream(annotation.excludes()).collect(Collectors.toSet());
        Object[] args = pjp.getArgs();
        boolean flag = true;
        for(Object arg : args){
            if (!(arg instanceof MultipartFile)){
                continue;
            }
            MultipartFile file = (MultipartFile) arg;
            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            int i = originalFilename.lastIndexOf(".");
            String suffix ="";
            if(i!=-1){
                suffix = originalFilename.substring(i);
                if(!includes.contains(suffix)){
                   flag = false;
                }else if(excludes.contains(suffix)){
                    flag = false;
                }
            }
            if(!flag){
                break;
            }
        }
        if(!flag){
            return Result.failure("该文件格式不支持");
        }
        return pjp.proceed();
    }
}
