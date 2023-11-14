package org.hoanguyen.register.repository;

import org.hoanguyen.register.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    public Optional<Account> findByAcNumber(Integer acNumber);
}
