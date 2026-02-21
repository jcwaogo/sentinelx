package net.jco.sentinelx.aspects_spring.repository;

import net.jco.sentinelx.aspects_spring.entity.AuditEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEventRepository extends JpaRepository<AuditEvent, Long> {

}
