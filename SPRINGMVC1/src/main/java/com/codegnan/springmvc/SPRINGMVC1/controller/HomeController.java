package com.codegnan.springmvc.SPRINGMVC1.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String test(HttpServletResponse response) throws IOException {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/checkLogin")
    public String checkLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        if (username.equals("Pavan") && password.equals("Pavan12345")) {
            return "success";
        }

        return "failed";
    }
}