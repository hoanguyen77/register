package org.hoanguyen.register.Repository;

import org.hoanguyen.register.entity.Member;
import org.hoanguyen.register.repository.MemberRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
     Member member;

    @BeforeEach
    public void init() {
        member = new Member();
        member.setFirstName("x");
        member.setLastName("x1");
        member.setEmail("x@x");
        member.setPhoneNumber("123456789");
    }

    @Test
    @Order(1)
    public void testSaveMember(){
        memberRepository.save(member);
        Assertions.assertTrue(memberRepository.count()>0);
    }
    @Test
    @Order(2)
    public void testFindMemberByEmail(){
        String expectedEmail = "x@x";
        Member actualMember = memberRepository.
                findMemberByEmail(expectedEmail).get();
        Assertions.assertEquals("x@x", actualMember.getEmail());

    }

}
