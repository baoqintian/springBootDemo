package com.org.a.springboot.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target:注解的作用目标。@Target(ElementType.PARAMETER) //方法参数@Target(ElementType.METHOD) //方法　　　　
@Target({ ElementType.PARAMETER, ElementType.METHOD })
//  @Retention：注解的保留位置。
//  @Retention(RetentionPolicy.RUNTIME) 注解会在class字节码文件中存在，在运行时可以通过反射获取到　
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

	String value() default "";
}
