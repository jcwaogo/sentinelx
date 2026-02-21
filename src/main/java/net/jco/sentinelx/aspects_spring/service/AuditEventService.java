package net.jco.sentinelx.aspects_spring.service;

import net.jco.sentinelx.aspects_spring.entity.AuditEvent;

import java.util.List;

public interface AuditEventService {
    public AuditEvent save(AuditEvent auditEvent);
    public AuditEvent findById(Long id);
    public AuditEvent update(AuditEvent auditEvent);
    public AuditEvent deleteById(Long id);
    public AuditEvent delete(AuditEvent auditEvent);
    public List<AuditEvent> findAll();
}
