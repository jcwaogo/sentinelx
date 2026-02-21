package net.jco.sentinelx.aspects_spring.audit;

import lombok.extern.slf4j.Slf4j;
import net.jco.sentinelx.aspects_spring.annotation.Auditable;
import net.jco.sentinelx.aspects_spring.entity.AuditEvent;
import net.jco.sentinelx.aspects_spring.repository.AuditEventRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AuditEventAspect {

    Long start_time;

    AuditEventRepository auditEventRepository;
    @Autowired
    public AuditEventAspect(AuditEventRepository auditEventRepository) {
        this.auditEventRepository = auditEventRepository;
    }

    @Before("execution(* net.jco.sentinelx.core..*Controller(..))")
    public void temps_demarrage(JoinPoint joinPoint){
        start_time = System.currentTimeMillis();
    }

    @AfterReturning(
            pointcut = "@annotation(auditable)",
            returning = "result"
    )

    public void audit(JoinPoint joinPoint, Auditable auditable, Object result) {

        AuditEvent entry = AuditEvent.builder()
                .timestamp(LocalDateTime.now())
                .action(auditable.action())
                .status(auditable.status())
                .methodSignature(joinPoint.getSignature().toShortString())
                .resultSummary(result != null ? result.toString() : "void")
                .argsSummary(Arrays.toString(joinPoint.getArgs()))
                .durationMs(System.currentTimeMillis() - start_time)
                .build();

        auditEventRepository.save(entry);

    }

}
