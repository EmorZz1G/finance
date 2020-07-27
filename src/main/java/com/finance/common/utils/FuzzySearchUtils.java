package com.finance.common.utils;

import org.springframework.util.StringUtils;
import sun.awt.SunHints;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Emor
 * 钟智杰真牛逼啊！但是没有反射牛逼！
 */
public class FuzzySearchUtils {


    /*public static Object autoWrapper(Class clazz, Map<String, String> queries) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Object example = clazz.newInstance();
        Method createCriteria = example.getClass().getDeclaredMethod("createCriteria");
        Object criteria = createCriteria.invoke(example);
        Method[] _methods = criteria.getClass().getDeclaredMethods();
        Set<Method> methods = Arrays
                .stream(_methods)
                .filter(method -> !method.getName().contains("Not") && method.getName().contains("Like"))
                .collect(Collectors.toSet());
        Set<String> strings = queries.keySet();
        for (String name : strings) {
            if (StringUtils.isEmpty(queries.get(name))) {
                continue;
            }
            for (Method method : methods) {
                boolean contains = method.getName().toLowerCase().contains(name);
                if (contains) {
                    method.invoke(criteria, "%" + queries.get(name) + "%");
                    break;
                }
            }
        }
        return example;
    }*/

    /**
     * 自动封装查询
     * @param clazz Example的类
     * @param queries 查询的Query
     * @return Example类实例
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static Object autoWrapper(Class clazz, Map<String, Object> queries) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Object example = clazz.newInstance();
        Method createCriteria = example.getClass().getDeclaredMethod("createCriteria");
        Object criteria = createCriteria.invoke(example);
        Method[] _methods = criteria.getClass().getDeclaredMethods();
        Set<Method> methods = Arrays
                .stream(_methods)
                .filter(method -> !method.getName().contains("Not") && !method.getName().contains("Or")
                        && (method.getName().contains("Like") || method.getName().contains("EqualTo")))
                .collect(Collectors.toSet());

        Set<String> strings = queries.keySet();
        for (String name : strings) {
            if (queries.get(name) == null
                    || (queries.get(name) instanceof String) && (((String) queries.get(name)).trim().equals(""))) {
                continue;
            }
            for (Method method : methods) {
                boolean contains = method.getName().toLowerCase().contains(name.toLowerCase());
                boolean like = method.getName().contains("Like");
                boolean equal = method.getName().contains("Equal");
                if (contains) {
                    Object value = queries.get(name);
                    if (value instanceof String && like) {
                        method.invoke(criteria, "%" + value + "%");
                        break;
                    } else if (!(value instanceof String) && equal) {
                        method.invoke(criteria, value);
                        break;
                    }
                }
            }
        }

        strings = queries.keySet().stream()
                .filter(s -> s.startsWith("min-") || s.startsWith("max-")).collect(Collectors.toSet());
        if (strings.size() % 2 == 1) {
            return example;
        }
        Set<String> min_strings = strings.stream()
                .filter(s -> s.startsWith("min-"))
                .collect(Collectors.toSet());
        Set<String> max_strings = strings.stream()
                .filter(s -> s.startsWith("max-"))
                .collect(Collectors.toSet());
        if (min_strings.size() != max_strings.size()) {
            throw new RuntimeException("插入的参数无法匹配，MIN-和MAX-的参数个数应该相同");
        }
        Set<Method> methodsBetween = Arrays
                .stream(_methods)
                .filter(method -> !method.getName().contains("Not") && method.getName().contains("Between"))
                .collect(Collectors.toSet());
        for (String key : min_strings) {
            if (queries.get(key) == null
                    || (queries.get(key) instanceof String) && ((String) queries.get(key)).trim().equals("")) {
                continue;
            }
            String no_min_key = key.substring(4);
            Object min = queries.get(key);
            Object max = queries.get("max-" + no_min_key);
            for (Method method : methodsBetween) {
                boolean contains = method.getName().toLowerCase().contains(no_min_key.toLowerCase());
                if (contains) {
                    method.invoke(criteria, min, max);
                    break;
                }
            }
        }
        return example;
    }
}