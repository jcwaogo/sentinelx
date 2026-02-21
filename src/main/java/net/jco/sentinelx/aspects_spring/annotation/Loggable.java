package net.jco.sentinelx.aspects_spring.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable {
    boolean logArgs() default true;
    boolean logResult() default true;
    boolean logExecutionTime() default true;
}
