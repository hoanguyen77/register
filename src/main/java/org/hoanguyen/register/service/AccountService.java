package org.hoanguyen.register.service;

import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.entity.Account;
import org.hoanguyen.register.dto.MemberDTO;

public interface AccountService {
    public AccountDTO createAccount(AccountDTO accountDTO);

    public void deposit(double amount, MemberDTO memberDTO);

    public void withdraw(double amount, MemberDTO memberDTO);
    public void saveAccount(AccountDTO accountDTO);

}
