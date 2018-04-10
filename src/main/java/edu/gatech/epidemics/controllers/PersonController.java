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
    public String list() {
        System.out.println("List all patients");
        return "person/list";
    }

    @GetMapping(value = "/person/edit")
    public String edit() {
        System.out.println("Edit patient");
        return "person/edit";
    }

    @GetMapping(value = "/person/view")
    public String view() {
        System.out.println("View patient");
        return "person/view";
    }
}