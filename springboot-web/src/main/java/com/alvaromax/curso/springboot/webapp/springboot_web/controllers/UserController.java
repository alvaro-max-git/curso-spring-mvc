package com.alvaromax.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.alvaromax.curso.springboot.webapp.springboot_web.models.User;


@Controller //indicamos que es un controlador de Spring.
public class UserController {

    //Un controlador procesa un request y devuelve un response.


    //método handler. Devuelve una plantilla de Thymeleaf.
    @GetMapping("/details")
    public String details (Model model) {
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("name", "Álvaro");
        model.addAttribute("lastname", "Muñoz");
        //model.addAttribute("email", "alvaro@nttdata.com");
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

    @GetMapping("/list")
    public String list (ModelMap model) {   //podemos usar ModelMap, que hereda de LinkedHashMap

        // model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
            new User("Álvaro", "Muñoz", "alvaro@nttdata.com"), 
            new User("Anita", "Rotchild"),
            new User("Susana", "Conejo"),
            new User("James", "Hetfield", "james@megadeth.com"));
    }
    
}
