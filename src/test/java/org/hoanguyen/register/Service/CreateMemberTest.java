package org.hoanguyen.register.Service;

import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.dto.MemberDTO;
import org.hoanguyen.register.entity.Account;
import org.hoanguyen.register.entity.Member;
import org.hoanguyen.register.repository.AccountRepository;
import org.hoanguyen.register.repository.MemberRepository;
import org.hoanguyen.register.service.AccountService;
import org.hoanguyen.register.service.MemberService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class CreateMemberTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountService accountService;

    Member member;
    MemberDTO memberDTO;
    AccountDTO accountDTO;
    Account account;

    @Test
    public void testCreateMember() {
        memberDTO = new MemberDTO();
        memberDTO.setFirstName("x");
        memberDTO.setLastName("x2");

        memberDTO.setEmail("x2@x2");
        accountDTO = new AccountDTO();
        accountDTO.setBalance(0.0);
//    accountService.createAccount(accountDTO);
        int uniqueRandomInt = Math.abs(UUID.randomUUID().hashCode());
        accountDTO.setAcNumber(uniqueRandomInt);
        accountService.saveAccount(accountDTO);

        memberDTO.setAccount(accountDTO);
        memberService.saveMember(memberDTO, accountDTO);


        memberService.createMember(memberDTO, accountDTO);
        Assertions.assertTrue(memberRepository.count() > 0);
    }
}
