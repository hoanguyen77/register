package org.hoanguyen.register.service;

import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.dto.MemberDTO;
import org.hoanguyen.register.entity.Account;
import org.hoanguyen.register.entity.Member;

import java.util.List;

public interface MemberService{
    public void saveMember(MemberDTO memberDTO, AccountDTO accountDTO);
    public List<MemberDTO> getAllMembers();

    public MemberDTO findMemberByEmail(String email);

    public List<MemberDTO> searchMembersByLastName(String name);
    public MemberDTO createMember(MemberDTO memberDTO, AccountDTO accountDTO);
}
