package net.jco.sentinelx.aspects_spring.repository;

import net.jco.sentinelx.aspects_spring.entity.ProfilingTrace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilingTraceRepository extends JpaRepository<ProfilingTrace, Long> {
}
