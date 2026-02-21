package net.jco.sentinelx.aspects_spring.service.impl;

import net.jco.sentinelx.aspects_spring.entity.ProfilingTrace;
import net.jco.sentinelx.aspects_spring.repository.ProfilingTraceRepository;
import net.jco.sentinelx.aspects_spring.service.ProfilingTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilingTraceServiceImpl implements ProfilingTraceService {

    ProfilingTraceRepository profilingTraceRepository;
    @Autowired
    public ProfilingTraceServiceImpl(ProfilingTraceRepository profilingTraceRepository) {
        this.profilingTraceRepository = profilingTraceRepository;
    }

    @Override
    public List<ProfilingTrace> findAll() {
        return profilingTraceRepository.findAll();
    }

    @Override
    public ProfilingTrace findById(Long id) {
        return profilingTraceRepository.findById(id).orElse(null);
    }

    @Override
    public ProfilingTrace save(ProfilingTrace profilingTrace) {
        return profilingTraceRepository.save(profilingTrace);
    }

    @Override
    public ProfilingTrace update(ProfilingTrace profilingTrace) {
        return profilingTraceRepository.save(profilingTrace);
    }

    @Override
    public ProfilingTrace delete(ProfilingTrace profilingTrace) {
        profilingTraceRepository.delete(profilingTrace);
        return profilingTrace;
    }

    @Override
    public ProfilingTrace deleteById(Long id) {
        ProfilingTrace profilingTrace = profilingTraceRepository.findById(id).orElse(null);
        profilingTraceRepository.delete(profilingTrace);
        return profilingTrace;
    }

}
