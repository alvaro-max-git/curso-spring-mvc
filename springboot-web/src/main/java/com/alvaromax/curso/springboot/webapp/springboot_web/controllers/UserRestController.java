package com.alvaromax.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaromax.curso.springboot.webapp.springboot_web.models.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String,Object> detailsrest () {

        User user = new User ("Álvaro", "Muñoz");
        Map<String, Object> body = new HashMap<>();

        body.put("user", user);
        body.put("date", (new Date()).toString());

        return body;
    }
    
}
