package net.jco.sentinelx.aspects_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"trace_id"}))
@Entity(name = "stlx_profiling_trace")
public class ProfilingTrace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_profiling_trace")
    @SequenceGenerator(name = "seq_profiling_trace", sequenceName = "seq_profiling_trace_id", initialValue = 1, allocationSize = 1)
    @Column(name="profiling_trace_id")
    private Long id;

    @Column(name="trace_id")
    private String traceId;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name="root_operation")
    private String rootOperation;

    @Column(name="total_duration_ms")
    private Long totalDurationMs;

    @Column(name="thread_name")
    private String threadName;
}
