package net.jco.sentinelx.aspects_spring.service;

import net.jco.sentinelx.aspects_spring.entity.ProfilingTrace;

import java.util.List;

public interface ProfilingTraceService {
    public List<ProfilingTrace> findAll();
    public ProfilingTrace findById(Long id);
    public ProfilingTrace save(ProfilingTrace profilingTrace);
    public ProfilingTrace update(ProfilingTrace profilingTrace);
    public ProfilingTrace delete(ProfilingTrace profilingTrace);
    public ProfilingTrace deleteById(Long id);
}
