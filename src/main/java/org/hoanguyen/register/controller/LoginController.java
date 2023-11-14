package org.hoanguyen.register.controller;

import org.hoanguyen.register.dto.AccountDTO;
import org.hoanguyen.register.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    MemberDTO memberDTO;
    AccountDTO accountDTO;
    @GetMapping("/")
    public String index(Model model)
    {

        return "index";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/home")
    public String redirectToAccount()
    {
        return "redirect:/account";
    }
}
