package com.finance.common.annotation;

public @interface BindEntity {

    Class value();

    String column() default "";

}
