package vn.hoidanit.laptopshop.controller;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/minhquan")
    public String getHomePage() {
        String test = this.userService.handleHello();
        return "eric.html";
    }
}
