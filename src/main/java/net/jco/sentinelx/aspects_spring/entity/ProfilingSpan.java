package net.jco.sentinelx.aspects_spring.entity;

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
@Entity(name = "stlx_profiling_span")
public class ProfilingSpan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_profiling_span")
    @SequenceGenerator(name = "seq_profiling_span", sequenceName = "seq_profiling_span_id", initialValue = 1, allocationSize = 1)
    @Column(name="profiling_id")
    private Long id;

    @Column(name="span_id")
    private String spanId;

    @Column(name="parent_span_id")
    private String parentSpanId;

    @ManyToOne
    @JoinColumn(name = "profiling_trace_id", referencedColumnName = "profiling_trace_id")
    private ProfilingTrace traceId;

    @Column(name="operation")
    private String operation;

    @Column(name="depth")
    private Integer depth;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name="duration_ms")
    private Long durationMs;

    @Column(name="order_index")
    private Integer orderIndex;

}
