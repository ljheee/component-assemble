package com.ljheee.cache;

import java.lang.annotation.*;

/**
 * 标识需要 被AOP增强的切点
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NeedSetFieldValue {
}
