package org.hoanguyen.register.controller;

import org.hoanguyen.register.dto.FindModel;
import org.hoanguyen.register.dto.MemberDTO;
<<<<<<< HEAD
import org.hoanguyen.register.dto.SeniorDTO;
import org.hoanguyen.register.dto.UserDTO;
import org.hoanguyen.register.entity.Role;
import org.hoanguyen.register.entity.User;
import org.hoanguyen.register.service.MemberService;
import org.hoanguyen.register.service.SeniorService;
import org.hoanguyen.register.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
=======
import org.hoanguyen.register.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73

@Controller
public class ListController {
    private static final Logger logger = LoggerFactory.getLogger(ListController.class.getName());
    private MemberService memberService;
<<<<<<< HEAD
    private UserService userService;
    private SeniorService seniorService;


    @Autowired
    public ListController(MemberService memberService, UserService userService, SeniorService seniorService) {
        this.memberService = memberService;
        this.userService = userService;
        this.seniorService = seniorService;
    }


    @GetMapping("/detail")
    public String detail(@AuthenticationPrincipal UserDetails userDetails, Model model){
        UserDTO userDTO = userService.findUserByEmail(userDetails.getUsername());

        List<Role> roleList = userDTO.getRole().stream().collect(Collectors.toList());


        if(roleList.get(0).getName().equals("ROLE_MEMBER")) {
            MemberDTO memberDTO = memberService.findMemberByEmail(userDetails.getUsername());
            model.addAttribute("member", memberDTO);
        }
        else
        {
            SeniorDTO seniorDTO = seniorService.findSeniorByEmail(userDetails.getUsername());
            model.addAttribute("senior", seniorDTO);
        }
        return "detail";
=======

    @Autowired
    public ListController(MemberService memberService) {
        this.memberService = memberService;

    }
    @GetMapping("/account")
    public String tranForm(Model model){
            model.addAttribute("member",
                    memberService.getAllMembers());

        return "account";
>>>>>>> 067d4aa9f30180f12c718988c5537b6ecf6ffe73
}

    @GetMapping("/list-of-members")
    public String listOfMembers(Model model){

        model.addAttribute("members", memberService.getAllMembers());

        return "all-members";
    }
    @GetMapping("/search")
    public String findMemberByLastName(Model model)
    {
        model.addAttribute("name", new FindModel());

        return "member-search";
    }

    @PostMapping("/search-result")
    public String searchResult(@ModelAttribute("name") FindModel findModel, Model model)
    {
        List<MemberDTO> memberDTOList =  memberService.searchMembersByLastName(findModel.getName());

        model.addAttribute("members", memberDTOList);

        return "search-result";
    }
    @GetMapping("/find-member-by-email")
    public String findUserByEmail(@RequestParam("email") String email, Model model)
    {
        model.addAttribute("member",memberService.findMemberByEmail(email));

        return "member-info";
    }
    @GetMapping("/find-member-by-email/{email}")
    public String findUserByEmailUsingPathVariable(@PathVariable("email") String email, Model model)
    {
        model.addAttribute("member",memberService.
                findMemberByEmail(email));

        return "member-info";
    }

}
