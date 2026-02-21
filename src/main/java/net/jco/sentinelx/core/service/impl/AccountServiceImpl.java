package net.jco.sentinelx.core.service.impl;

import net.jco.sentinelx.core.entity.Account;
import net.jco.sentinelx.core.repository.AccountRepository;
import net.jco.sentinelx.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(Account account) {
        accountRepository.delete(account);
        return account;
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account deleteById(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
        accountRepository.delete(account);
        return account;
    }
}
