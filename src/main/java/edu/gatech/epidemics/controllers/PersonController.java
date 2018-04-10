package edu.gatech.epidemics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author atalati
 */
@Controller
public class PersonController {
//    @PostMapping(value = "/")
//    public final String post(Login loginInput) {
//        System.out.println("HTTP POST: \"/api/login/\" : " + loginInput.toString());
//        if (loginInput.getUsername().equals("aarsh") && loginInput.getPassword().equals("test")) {
//            return "home";
//        } else {
//            return "redirect:/";
//        }
//    }

    @GetMapping(value = {"/", "/person/list"})
    public String patient() {
        System.out.println("List all patients");
        return "person/list";
    }
}