package org.hoanguyen.register.service;

import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.dto.MemberDTO;
import org.hoanguyen.register.entity.Account;
import org.hoanguyen.register.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;

   @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;

    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Account account = modelMapper.map(accountDTO, Account.class);
        account.setBalance(0.0);
//        account.setAcNumber(UUID.randomUUID().toString());
        int uniqueRandomInt = Math.abs(UUID.randomUUID().hashCode());
        account.setAcNumber(uniqueRandomInt);
        accountRepository.save(account);

        return accountDTO;
//        accountRepository.findByAcNumber(accountDTO.getAcNumber()).orElse(null)
    }

    @Override
    public void deposit(double amount, MemberDTO memberDTO) {

    }

    @Override
    public void withdraw(double amount, MemberDTO memberDTO) {

    }

    @Override
    public void saveAccount(AccountDTO accountDTO) {

    }
}
