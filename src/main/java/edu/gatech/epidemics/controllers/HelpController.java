package edu.gatech.epidemics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author atalati
 */
@Controller
public class HelpController {
    @GetMapping(value = "/help/index")
    public String index() {
        return "help/index";
    }
}
