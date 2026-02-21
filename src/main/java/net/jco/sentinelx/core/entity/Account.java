package net.jco.sentinelx.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.jco.sentinelx.enumeration.Currency;
import net.jco.sentinelx.enumeration.StatusAccount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"account_number"}))
@Entity(name="stlx_account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_account")
    @SequenceGenerator(name="seq_account", sequenceName = "seq_account_id", initialValue = 1, allocationSize = 1)
    @Column(name="account_id")
    private Long id;

    @Column(name="account_number")
    private String accountNumber;

    @Column(name="owner_name")
    private String ownerName;

    @Enumerated(EnumType.STRING)
    @Column(name="currency")
    private Currency currency;

    @Column(name="balance")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusAccount status;

    @Column(name = "daily_transfer_limit")
    private BigDecimal dailyTransferLimit;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist public void prePersist() { createdAt = LocalDateTime.now(); updatedAt = LocalDateTime.now(); }
    @PreUpdate public void preUpdate() { updatedAt = LocalDateTime.now(); }

    @Column(name = "version")
    private Long version;

}
