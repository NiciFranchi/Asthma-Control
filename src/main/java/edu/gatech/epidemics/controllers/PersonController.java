package edu.gatech.epidemics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author atalati
 */
@Controller
public class PersonController {

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

    @GetMapping(value = "/person/import")
    public String view() {
        System.out.println("Import patient from FHIR");
        return "person/import";
    }
}