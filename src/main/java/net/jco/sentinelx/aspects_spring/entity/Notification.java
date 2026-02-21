package net.jco.sentinelx.aspects_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.jco.sentinelx.core.entity.Account;
import net.jco.sentinelx.core.entity.Transfer;
import net.jco.sentinelx.enumeration.NotificationChannel;
import net.jco.sentinelx.enumeration.StatusTransfert;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="stlx_notification")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_notification")
    @SequenceGenerator(name="seq_notification", sequenceName = "seq_notification_id", initialValue = 1, allocationSize = 1)
    @Column(name="notification_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transfert_id", referencedColumnName = "transfert_id")
    private Transfer transferId;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel")
    private NotificationChannel channel;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "message")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusTransfert status;

    @Column(name = "attempt_count")
    private Integer attemptCount;

    @Column(name = "lastError")
    private String lastError;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @PrePersist public void prePersist() { createdAt = LocalDateTime.now(); }

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

}
