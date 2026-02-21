package net.jco.sentinelx.aspects_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="stlx_fee_computation")
public class FeeComputation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_free_computation")
    @SequenceGenerator(name = "seq_free_computation", sequenceName = "seq_free_computation_id", initialValue = 1, allocationSize = 1)
    @Column(name = "fee_computation_id")
    private Long id;

    @Column(name="input_amount")
    private BigDecimal inputAmount;

    @Column(name="fee_amount")
    private BigDecimal feeAmount;

    @Column(name = "algorithm")
    private String algorithm;

    @Column(name = "computed_at")
    private LocalDateTime computedAt;

    @Column(name = "computed_by")
    private String computedBy;

}
