package edu.gatech.epidemics.controller;

import edu.gatech.epidemics.viewmodel.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author atalati
 */
@Controller
public class HomeController {
    @PostMapping(value = "/")
    public final String post(@RequestBody Login loginInput) {
        System.out.println("HTTP POST: \"/api/login/\" : " + loginInput.toString());
        if (loginInput.getUsername() == "aarsh" && loginInput.getPassword() == "test") {
            return "redirect:/home";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping(value = "/")
    public String get() {
        System.out.println("index");
        return "index";
    }
}