package edu.gatech.epidemics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author atalati
 */
@Controller
public class QuestionnaireController {

    @GetMapping(value = "questionnaire/list")
    public String index(){
        System.out.println("Load questionnaire");
        return "questionnaire/list";
    }

    @GetMapping(value = "questionnaire/result")
    public String result(){
        System.out.println("Load questionnaire");
        return "questionnaire/result";
    }
}
