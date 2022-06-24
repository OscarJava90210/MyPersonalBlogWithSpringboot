package com.simplform.Registrationform.controller;

import com.simplform.Registrationform.model.UsersModel;
import com.simplform.Registrationform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UsersModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest",new UsersModel());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel){
        System.out.println("register_request: " + usersModel);
        UsersModel registerUser =  userService.registerUser(usersModel.getLogin(), usersModel.getPassword(), usersModel.getEmail());
        return  registerUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login (@ModelAttribute UsersModel usersModel, Model model){
        System.out.println("login_request: " + usersModel);
        String authenticated =  userService.authenticate (usersModel.getLogin(), usersModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "personal_page";
        }else {
            return "error_page";
        }
    }
}
