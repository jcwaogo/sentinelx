package net.jco.sentinelx.aspects_spring.annotation;

import net.jco.sentinelx.enumeration.AuditEventStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Auditable {
    String action();
    AuditEventStatus status() default AuditEventStatus.SUCCESS;
}
