package net.jco.sentinelx.aspects_aspectj.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name="stlx_retry_execution")
public class RetryExecution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_retry_execution")
    @SequenceGenerator(name = "seq_retry_execution", sequenceName = "seq_retry_execution_id", initialValue = 1, allocationSize = 1)
    @Column(name="retry_execution_id")
    private Long id;

    @Column(name="operation")
    private String operation;

    @Column(name="max_attempts")
    private Integer maxAttempts;

    @Column(name="delay_ms")
    private Long delayMs;

    @Column(name="retry_on")
    private String retryOn;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "success")
    private Boolean success;

    @Column(name="final_exception_class")
    private String finalExceptionClass;

    @Column(name="final_exception_message")
    private String finalExceptionMessage;

    @Column(name="trace_id")
    private String traceId;

}
