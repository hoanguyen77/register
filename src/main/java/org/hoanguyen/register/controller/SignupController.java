//package org.hoanguyen.register.controller;
//
//import jakarta.validation.Valid;
//import org.hoanguyen.register.dto.UserDTO;
//import org.hoanguyen.register.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class SignupController {
//
//    private UserService userService;
//    @Autowired
//    public SignupController(UserService userService) {
//        this.userService = userService;
//    }
//    @GetMapping("/user-sign-up")
//    public String signUpForm(Model model){
//
//        model.addAttribute("userDto", new UserDTO());
//
//        return "user-sign-up";
//    }
//
//
//    @PostMapping("/process-user")
//    public String signUpProcess(@Valid @ModelAttribute("userDto") UserDTO userDTO,
//                                BindingResult bindingResult)
//    {
//        if(bindingResult.hasErrors())
//        {
//            return "user-sign-up";
//        }
//
//        userService.saveUser(userDTO);
//
//
//        return "redirect:/confirmation";
//    }
//
//
//    @GetMapping("/confirmation")
//    public String confirmationPage()
//    {
//        return "confirmation";
//    }
//
//
//
//}
