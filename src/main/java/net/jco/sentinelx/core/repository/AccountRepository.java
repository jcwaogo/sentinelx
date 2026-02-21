package net.jco.sentinelx.core.repository;

import net.jco.sentinelx.core.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
