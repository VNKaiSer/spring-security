package com.example.springserurity.controllers;

import com.example.springserurity.models.User;
import com.example.springserurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    @Autowired private UserService userService;
    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/addUser")
    public String getInsertUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("message", "Người dùng đã được thêm thành công!");

        return "redirect:/login";
    }


}
