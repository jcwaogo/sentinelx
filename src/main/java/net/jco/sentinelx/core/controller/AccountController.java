package net.jco.sentinelx.core.controller;

import net.jco.sentinelx.aspects_spring.annotation.Auditable;
import net.jco.sentinelx.core.entity.Account;
import net.jco.sentinelx.core.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class AccountController {

    AccountServiceImpl accountServiceImpl;

    @Autowired
    public AccountController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    @GetMapping("/all")
    public List<Account> accountList() {
        return accountServiceImpl.findAll();
    }

    @PostMapping("/save")
    @Auditable(action="CREATE ACCOUNT")
    public Account saveAccount(@RequestBody Account account) {
        return accountServiceImpl.save(account);
    }

    @PostMapping("/update")
    public Account updateAccount(@RequestBody Account account) {
        return accountServiceImpl.update(account);
    }

    @PostMapping("/delete")
    public void deleteAccount(@RequestBody Account account) {
        accountServiceImpl.delete(account);
    }

    @GetMapping("/delete/{id}")
    public Account deleteAccountById(@PathVariable Long id) {
        return accountServiceImpl.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Account findAccountById(@PathVariable Long id) {
        return accountServiceImpl.findById(id);
    }
}
