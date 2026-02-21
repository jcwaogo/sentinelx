package net.jco.sentinelx.aspects_spring.controller;

import net.jco.sentinelx.aspects_spring.entity.AuditEvent;
import net.jco.sentinelx.aspects_spring.service.impl.AuditEventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit_event")
@CrossOrigin("*")
public class AuditEventController {
    AuditEventServiceImpl auditEventServiceImpl;
    @Autowired
    public AuditEventController(AuditEventServiceImpl auditEventServiceImpl) {
        this.auditEventServiceImpl = auditEventServiceImpl;
    }
    @GetMapping("/all")
    public List<AuditEvent> auditEventList() {
        return auditEventServiceImpl.findAll();
    }
    @GetMapping("/find/{id}")
    public AuditEvent findAuditEventById(@PathVariable Long id) {
        return auditEventServiceImpl.findById(id);
    }
    @PostMapping("/save")
    public AuditEvent saveAuditEvent(@RequestBody AuditEvent auditEvent) {
        return auditEventServiceImpl.save(auditEvent);
    }
    @PostMapping("/update")
    public AuditEvent updateAuditEvent(@RequestBody AuditEvent auditEvent) {
        return auditEventServiceImpl.save(auditEvent);
    }
    @PostMapping("/delete")
    public AuditEvent deleteAuditEvent(@RequestBody AuditEvent auditEvent) {
        return auditEventServiceImpl.delete(auditEvent);
    }
    @GetMapping("/delete/{id}")
    public AuditEvent deleteAuditEventById(@PathVariable Long id) {
        return auditEventServiceImpl.deleteById(id);
    }
}
