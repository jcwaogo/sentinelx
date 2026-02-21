package net.jco.sentinelx.core.entity;

import jakarta.persistence.*;
import net.jco.sentinelx.enumeration.Currency;
import net.jco.sentinelx.enumeration.StatusTransfert;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="stlx_transfer")
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_transfert")
    @SequenceGenerator(name = "seq_transfert", sequenceName = "seq_transfert_id", initialValue = 1, allocationSize = 1)
    @Column(name = "transfert_id")
    private Long id;

    @Column(name = "reference")
    private String reference;

    @ManyToOne
    @JoinColumn(name = "from_account_id", referencedColumnName = "account_id")
    private Account fromAccountId;

    @ManyToOne
    @JoinColumn(name = "to_account_id", referencedColumnName = "account_id")
    private Account toAccountId;

    @Column(name="amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name="currency")
    private Currency currency;

    @Column(name = "label")
    private String label;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusTransfert status;

    @Column(name = "requested_at")
    private LocalDateTime requestedAt;

    @Column(name = "executed_at")
    private LocalDateTime executedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @PrePersist public void prePersist() { createdAt = LocalDateTime.now(); }

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "failure_code")
    private String failureCode;

    @Column(name = "failure_message")
    private String failureMessage;

}
