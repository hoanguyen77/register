package org.hoanguyen.register.Service;

import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.dto.MemberDTO;
import org.hoanguyen.register.entity.Account;
import org.hoanguyen.register.entity.Member;
import org.hoanguyen.register.exception.UserExistException;
import org.hoanguyen.register.repository.AccountRepository;
import org.hoanguyen.register.repository.MemberRepository;
import org.hoanguyen.register.service.AccountService;
import org.hoanguyen.register.service.MemberService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberServiceTest {
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
    @BeforeEach
    public void init()
    {
        memberDTO = new MemberDTO();
        memberDTO.setFirstName("x");
        memberDTO.setLastName("x1");

        memberDTO.setEmail("x@x");

    }

    @Test
    @Order(1)
    public void testSaveMember()  {
        memberService.saveMember(memberDTO, accountDTO);
        assertTrue(memberRepository.count()>0);
    }

    @Test
    @Order(2)
    public void testFindMemberByEmail(){
        String expectedEmail = "p@p";
        MemberDTO actualMember = memberService.
                findMemberByEmail(expectedEmail);
        Assertions.assertEquals("p@p", actualMember.getEmail());

    }
    @Test
    @Order(3)
    public void testGetAllMembers() {
        List<MemberDTO> memberDTOList = memberService.getAllMembers();
        assertNotNull(memberDTOList);
        assertTrue(memberDTOList.size()>=1);
    }
    @Test
    @Order(4)
    public void testSearchMembersByLastName()
    {
        String expectedLastName = "a";
        List<MemberDTO> memberDTOList = memberService.searchMembersByLastName(expectedLastName);
        Assertions.assertTrue(memberDTOList.size() > 0);

        memberDTOList.stream().forEach(s ->{
            Assertions.assertEquals("a", s.getLastName());
        });

    }

}



