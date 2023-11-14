package org.hoanguyen.register.service;

import jakarta.transaction.Transactional;
import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.dto.MemberDTO;
import org.hoanguyen.register.entity.Account;
import org.hoanguyen.register.entity.Member;
import org.hoanguyen.register.repository.AccountRepository;
import org.hoanguyen.register.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class.getName());
    private MemberRepository memberRepository;
    private AccountRepository accountRepository;

    private AccountService accountService;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository,
                             AccountRepository accountRepository        ) {
        this.memberRepository = memberRepository;
        this.accountRepository = accountRepository;

    }




    @Override
    public void saveMember(MemberDTO memberDTO, AccountDTO accountDTO) {
        if(memberRepository.findMemberByEmail(memberDTO.getEmail()).isPresent()){
            throw new RuntimeException("Account already exist");
        }
        else
        {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Member member = modelMapper.map(memberDTO, Member.class);
            Account account = modelMapper.map(accountDTO, Account.class);

            accountRepository.save(account);
            member.setAccount(account);
            memberRepository.save(member);
        }



    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> memberDTOS = new ArrayList<>();

        for(Member member : memberRepository.findAll())
        {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);

            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }

    @Override
    public MemberDTO findMemberByEmail(String email) {
        Optional<Member> userOptional = memberRepository.findMemberByEmail(email);
        try {

            if (userOptional.isPresent()) {
                Member member = userOptional.get();
                ModelMapper modelMapper = new ModelMapper();
                modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
                MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);
                return memberDTO;
            }
        } catch (RuntimeException exception) {
            throw new RuntimeException("User not found");
        }
        throw new RuntimeException("User not found");

    }

    @Override
    public List<MemberDTO> searchMembersByLastName(String name) {
        List<MemberDTO> memberDTOS = new ArrayList<>();

        for(Member member : memberRepository.findMembersByLastNameLike(name))
        {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);

            memberDTOS.add(memberDTO);
        }
        return memberDTOS;
    }
    @Override
    @Transactional
    public MemberDTO createMember(MemberDTO memberDTO, AccountDTO accountDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Member member = modelMapper.map(memberDTO, Member.class);

        if (memberRepository.findMemberByEmail(member.getEmail()) != null) {
            logger.info("Member with email {} already exists.", memberDTO.getEmail());
        } else {
            // If the member does not exist, create a new account
            AccountDTO newAccount = accountService.createAccount(accountDTO);

            // Set the account to the member
            memberDTO.getAccount();

            // Save the member with the new account
            memberRepository.save(member);

//            logger.info("Member with email {} created successfully with account ID {}.",
//                    memberDTO.getEmail(), newAccount.getId());
        }
        return memberDTO;
}
}
