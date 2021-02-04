package com.Serialization.Cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {

    CacheType cachetype();

    String name() default "Save";

    int maxSize() default 100;

    boolean isZip() default false;

}
