package com.finance.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Emor
 * 钟智杰真牛逼啊！但是没有反射牛逼！
 */
public class FuzzySearchUtils {


    public static Object autoWrapper(Class clazz, Map<String,String> queries) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Object example = clazz.newInstance();
//        System.out.println(example);
        Method createCriteria = example.getClass().getDeclaredMethod("createCriteria");
//        System.out.println(createCriteria);
        Object criteria = createCriteria.invoke(example);
        Method[] _methods = criteria.getClass().getDeclaredMethods();
        Set<Method> methods = Arrays.stream(_methods)
        .filter(method -> !method.getName().contains("Not")&&method.getName().contains("Like")).collect(Collectors.toSet());
//        System.out.println(methods);
        Set<String> strings = queries.keySet();
        for(String name:strings){
            for(Method method:methods){
                boolean contains = method.getName().toLowerCase().contains(name);
                if (contains){
                    method.invoke(criteria,"%"+queries.get(name)+"%");
                    break;
                }
            }
        }
        return example;
    }
}
