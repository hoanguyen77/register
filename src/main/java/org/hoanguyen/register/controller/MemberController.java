package org.hoanguyen.register.controller;

import jakarta.validation.Valid;
import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.dto.FindModel;
import org.hoanguyen.register.dto.MemberDTO;
import org.hoanguyen.register.dto.UserDTO;
import org.hoanguyen.register.service.AccountService;
import org.hoanguyen.register.service.MemberService;
import org.hoanguyen.register.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class.getName());
    private MemberService memberService;
    private AccountService accountService;
    private UserService userService;
    @Autowired
    public MemberController(MemberService memberService,
                            AccountService accountService,
                            UserService userService) {
        this.memberService = memberService;
        this.accountService = accountService;
        this.userService = userService;
    }

<<<<<<< HEAD
    @GetMapping("/member-sign-up")
    public String signUpForm(Model model){

        model.addAttribute("memberDto", new MemberDTO());
        model.addAttribute("account", new AccountDTO());
        model.addAttribute("user", new UserDTO());

        return "member-sign-up";
=======
    @GetMapping("/user-sign-up")
    public String signUpForm(Model model){

        model.addAttribute("userDto", new MemberDTO());
        model.addAttribute("account", new AccountDTO());
        model.addAttribute("user", new UserDTO());

        return "user-sign-up";
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73
    }


    @PostMapping("/process-user")
<<<<<<< HEAD
    public String signUpProcess(@Valid @ModelAttribute("memberDto") MemberDTO memberDTO,
=======
    public String signUpProcess(@Valid @ModelAttribute("userDto") MemberDTO memberDTO,
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73
                                BindingResult bindingResult,
                                @ModelAttribute ("account") AccountDTO accountDTO,
                                BindingResult acBindingResult,
                                @Valid @ModelAttribute ("user") UserDTO userDTO, BindingResult
                                            userBindingResult,
                                Model model){

        if(acBindingResult.hasErrors())
        {
            logger.warn("User wrong input " +
                    Arrays.toString(bindingResult.getSuppressedFields()));
<<<<<<< HEAD
            return "member-sign-up";
        }
        if(userBindingResult.hasErrors())
        {
            return "member-sign-up";
=======
            return "user-sign-up";
        }
        if(userBindingResult.hasErrors())
        {
            return "user-sign-up";
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73
        }
        try {
            int uniqueRandomInt = Math.abs(UUID.randomUUID().hashCode());
            accountDTO.setAcNumber(uniqueRandomInt);
            accountService.saveAccount(accountDTO);
            memberDTO.setAccount(accountDTO);
            memberService.saveMember(memberDTO, accountDTO);
            userDTO.setEmail(memberDTO.getEmail());
            userDTO.setRole("ROLE_MEMBER");
            userService.saveUser(userDTO);
        } catch (Exception e)
        {
            model.addAttribute("message", "User wrong input");
<<<<<<< HEAD
            return "member-sign-up";
=======
            return "user-sign-up";
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73
        }


        return "redirect:/confirmation";
    }


    @GetMapping("/confirmation")
    public String confirmationPage()
    {

        return "confirmation";
    }



}
