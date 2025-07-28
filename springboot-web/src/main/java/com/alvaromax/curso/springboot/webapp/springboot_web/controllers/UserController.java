package com.alvaromax.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;


@Controller //indicamos que es un controlador de Spring.
public class UserController {

    //Un controlador procesa un request y devuelve un response.


    //método handler. Devuelve una plantilla de Thymeleaf.
    @GetMapping("/details")
    public String details (Model model) {
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("name", "Álvaro");
        model.addAttribute("lastname", "Muñoz");
        model.addAttribute("date", (new Date()).toString());
        return "details"; //tiene que tener el mismo nombre que la plantilla en resources/templates
    }

    @GetMapping("/details2")
    public String details2 (Map <String, Object> model) {
        model.put("title", "Hola Mundo Spring Boot");
        model.put("name", "Álvaro");
        model.put("lastname", "Muñoz Pavón");
        model.put("date", (new Date()).toString());
        return "details";
    }
    

}
