package com.finance.common.aop;


import com.finance.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLNonTransientException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(SQLNonTransientException.class)
    @ResponseBody
    public Result handlerSQLIntegrityConstraintViolationException(Exception e) {
        LOGGER.info("主键冲突：" + e.getMessage() + "可以忽略");
        return Result.failure("邮箱或者手机号已存在");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handlerException(Exception e) {
        LOGGER.info(e.getMessage());
        return Result.failure("请一会再尝试");
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result handlerThrowable(Throwable e) {
        LOGGER.info(e.getMessage());
        return Result.failure("请一会再尝试");
    }
}
