package net.jco.sentinelx.aspects_aspectj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.jco.sentinelx.core.entity.Account;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="stlx_retry_attempt")
public class RetryAttempt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_retry_attempt")
    @SequenceGenerator(name = "seq_retry_attempt", sequenceName = "seq_retry_attempt_id", initialValue = 1, allocationSize = 1)
    @Column(name="retry_attempt_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "retry_execution_id", referencedColumnName = "retry_execution_id")
    private RetryExecution retryExecutionId;

    @Column(name="attempt_no")
    private Integer attemptNo;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name="duration_ms")
    private Long durationMs;

    @Column(name="exception_class")
    private String exceptionClass;

    @Column(name="exception_message")
    private String exceptionMessage;

    @Column(name="success")
    private Boolean success;

}
