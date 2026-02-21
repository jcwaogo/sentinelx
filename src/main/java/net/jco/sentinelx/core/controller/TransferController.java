package net.jco.sentinelx.core.controller;

import net.jco.sentinelx.aspects_spring.annotation.Auditable;
import net.jco.sentinelx.core.entity.Transfer;
import net.jco.sentinelx.core.service.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
@CrossOrigin("*")
public class TransferController {

    TransferServiceImpl transferServiceImpl;
    @Autowired
    public TransferController(TransferServiceImpl transferServiceImpl) {
        this.transferServiceImpl = transferServiceImpl;
    }

    @GetMapping("/all")
    public List<Transfer> transferList(){
        return transferServiceImpl.findAll();
    }

    @GetMapping("/find/{id}")
    public Transfer findByTransferId(@PathVariable Long id){
        return transferServiceImpl.findById(id);
    }

    @PostMapping("/save")
    @Auditable(action="CREATE_TRANSFERT")
    public Transfer saveTranfer(@RequestBody Transfer transfer){
        return transferServiceImpl.save(transfer);
    }

    @PostMapping("/update")
    public Transfer updateTransfer(@RequestBody Transfer transfer){
        return transferServiceImpl.save(transfer);
    }

    @PostMapping
    public Transfer deleteTransfer(@RequestBody Transfer transfer){
        return transferServiceImpl.delete(transfer);
    }

    @GetMapping("/delete/{id}")
    public void deleteTransferById(@PathVariable Long id){
        transferServiceImpl.deleteById(id);
    }
}
