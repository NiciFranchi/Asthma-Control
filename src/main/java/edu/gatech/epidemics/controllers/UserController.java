package edu.gatech.epidemics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author atalati
 */
@Controller
public class UserController {
    @GetMapping("/user/list")
    public String List() {
        return "user/list";
    }
}
