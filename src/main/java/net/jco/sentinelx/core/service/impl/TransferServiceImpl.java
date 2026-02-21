package net.jco.sentinelx.core.service.impl;

import net.jco.sentinelx.core.entity.Transfer;
import net.jco.sentinelx.core.repository.TransferRepository;
import net.jco.sentinelx.core.service.TransferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    TransferRepository transferRepository;
    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer findById(Long id) {
        return transferRepository.findById(id).orElse(null);
    }

    @Override
    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer update(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer delete(Transfer transfer) {
        transferRepository.delete(transfer);
        return transfer;
    }

    @Override
    public Transfer deleteById(Long id) {
        Transfer transfer = transferRepository.findById(id).orElse(null);
        transferRepository.delete(transfer);
        return transfer;
    }
}
