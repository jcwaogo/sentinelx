package net.jco.sentinelx.aspects_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.jco.sentinelx.enumeration.AuditEventStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "stlx_audit_event")
public class AuditEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "audit_event_id")
    @SequenceGenerator(name = "seq_audit_event", sequenceName = "seq_audit_event_id", initialValue = 1, allocationSize = 1)
    @Column(name="audit_event_id")
    private Long id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "action")
    private String action;

    @Column(name = "username")
    private String username;

    @Column(name = "method_signature")
    private String methodSignature;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private AuditEventStatus status;

    @Column(name = "duration_ms")
    private Long durationMs;

    @Column(name = "args_logged")
    private Boolean argsLogged;

    @Column(name = "args_masked")
    private Boolean argsMasked;

    @Column(name = "args_summary")
    private String argsSummary;

    @Column(name = "result_summary")
    private String resultSummary;

    @Column(name = "exception_class")
    private String exceptionClass;

    @Column(name = "exception_message")
    private String exceptionMessage;

    @Column(name = "trace_id")
    private String traceId;

}
