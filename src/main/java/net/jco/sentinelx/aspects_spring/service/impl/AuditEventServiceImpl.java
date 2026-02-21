package net.jco.sentinelx.aspects_spring.service.impl;

import net.jco.sentinelx.aspects_spring.entity.AuditEvent;
import net.jco.sentinelx.aspects_spring.repository.AuditEventRepository;
import net.jco.sentinelx.aspects_spring.service.AuditEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditEventServiceImpl implements AuditEventService {

    AuditEventRepository auditEventRepository;
    public AuditEventServiceImpl(AuditEventRepository auditEventRepository) {
        this.auditEventRepository = auditEventRepository;
    }

    @Override
    public AuditEvent save(AuditEvent auditEvent) {
        return auditEventRepository.save(auditEvent);
    }

    @Override
    public AuditEvent findById(Long id) {
        return auditEventRepository.findById(id).orElse(null);
    }

    @Override
    public AuditEvent update(AuditEvent auditEvent) {
        return auditEventRepository.save(auditEvent);
    }

    @Override
    public AuditEvent deleteById(Long id) {
        AuditEvent auditEvent = auditEventRepository.findById(id).orElse(null);
        auditEventRepository.delete(auditEvent);
        return auditEvent;
    }

    @Override
    public AuditEvent delete(AuditEvent auditEvent) {
        return auditEventRepository.save(auditEvent);
    }

    @Override
    public List<AuditEvent> findAll() {
        return auditEventRepository.findAll();
    }
}
