package net.jco.sentinelx.core.service;

import net.jco.sentinelx.core.entity.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public Account findById(Long id);
    public Account save(Account account);
    public Account delete(Account account);
    public Account update(Account account);
    public Account deleteById(Long id);
}
