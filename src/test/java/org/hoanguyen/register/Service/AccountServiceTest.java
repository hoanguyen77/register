package org.hoanguyen.register.Service;

import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.repository.AccountRepository;
import org.hoanguyen.register.service.AccountService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
import java.util.UUID;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountServiceTest {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountRepository accountRepository;

    AccountDTO accountDTO;

    @BeforeEach
    public void init(){

        accountDTO = new AccountDTO();
        int uniqueRandomInt = Math.abs(UUID.randomUUID().hashCode());
        accountDTO.setAcNumber(uniqueRandomInt);


    }
    @Test
    public void testCreateAccount(){
        accountService.createAccount(accountDTO);
        Assertions.assertTrue(accountRepository.count() > 0);
    }


}
