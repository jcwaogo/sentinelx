package net.jco.sentinelx.aspects_spring.controller;

import net.jco.sentinelx.aspects_spring.entity.ProfilingTrace;
import net.jco.sentinelx.aspects_spring.repository.ProfilingTraceRepository;
import net.jco.sentinelx.aspects_spring.service.impl.ProfilingTraceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiling_trace")
@CrossOrigin("*")
public class ProfilingTraceController {

    ProfilingTraceServiceImpl profilingTraceServiceImpl;
    @Autowired
    public ProfilingTraceController(ProfilingTraceServiceImpl profilingTraceServiceImpl) {
        this.profilingTraceServiceImpl = profilingTraceServiceImpl;
    }

    @GetMapping("/all")
    public List<ProfilingTrace> ProfilingTracesList(){
        return profilingTraceServiceImpl.findAll();
    }

    @GetMapping("/find/{id}")
    public ProfilingTrace findProfilingTraceById(@PathVariable Long id){
        return profilingTraceServiceImpl.findById(id);
    }

    @PostMapping("/save")
    public ProfilingTrace saveProfilingTrace(@RequestBody ProfilingTrace profilingTrace){
        return profilingTraceServiceImpl.save(profilingTrace);
    }

    @PostMapping("/update")
    public ProfilingTrace updateProfilingTrace(@RequestBody ProfilingTrace profilingTrace){
        return profilingTraceServiceImpl.save(profilingTrace);
    }

    @PostMapping("/delete")
    public ProfilingTrace deleteProfilingTrace(@RequestBody ProfilingTrace profilingTrace){
        return profilingTraceServiceImpl.delete(profilingTrace);
    }

    @GetMapping("/delete/{id}")
    public ProfilingTrace deleteProfilingTraceById(@PathVariable Long id){
        return profilingTraceServiceImpl.deleteById(id);
    }

}
