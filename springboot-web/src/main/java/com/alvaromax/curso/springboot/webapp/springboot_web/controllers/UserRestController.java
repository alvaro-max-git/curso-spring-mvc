package com.alvaromax.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaromax.curso.springboot.webapp.springboot_web.models.User;
import com.alvaromax.curso.springboot.webapp.springboot_web.models.dto.UserDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details () {
        
        UserDto userDto = new UserDto();
        User user = new User ("Álvaro", "Muñoz");
        
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");

        return userDto;
    }

    @GetMapping("/users")
    public List<User> getAllusers() {

        User user = new User ("Álvaro", "Muñoz");
        User user2 = new User ("Ángela", "Pérez");
        User user3 = new User ("Jane", "Doe");

        List<User> users = Arrays.asList(user, user2, user3);

        return users;
    }


    @GetMapping("/details-map")
    public Map<String,Object> detailsMap () {

        User user = new User ("Álvaro", "Muñoz");

        Map<String, Object> body = new HashMap<>();
        body.put("user", user);
        body.put("date", (new Date()).toString());

        return body;
    }
    
}
