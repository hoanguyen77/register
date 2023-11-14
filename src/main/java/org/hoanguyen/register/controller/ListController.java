package org.hoanguyen.register.controller;

import org.hoanguyen.register.dto.FindModel;
import org.hoanguyen.register.dto.MemberDTO;
import org.hoanguyen.register.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListController {
    private static final Logger logger = LoggerFactory.getLogger(ListController.class.getName());
    private MemberService memberService;

    @Autowired
    public ListController(MemberService memberService) {
        this.memberService = memberService;

    }
    @GetMapping("/account")
    public String tranForm(Model model){
            model.addAttribute("member",
                    memberService.getAllMembers());

        return "account";
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
