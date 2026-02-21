package net.jco.sentinelx.core.service;

import net.jco.sentinelx.core.entity.Transfer;

import java.util.List;

public interface TransferService {
    public List<Transfer> findAll();
    public Transfer findById(Long id);
    public Transfer save(Transfer transfer);
    public Transfer update(Transfer transfer);
    public Transfer delete(Transfer transfer);
    public Transfer deleteById(Long id);
}
