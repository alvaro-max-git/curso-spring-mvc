package com.alvaromax.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaromax.curso.springboot.webapp.springboot_web.models.User;
import com.alvaromax.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    //@Value("${config.message}")
    //private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;
    
    @Value("#{${config.valuesMap}.product}")
    private Map<String,Object> product;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz (@PathVariable String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mixPathVariable (@PathVariable String product, @PathVariable Long id) {

        Map<String,Object> params = new HashMap<>();

        params.put("product", product);
        params.put("id", id);

        return params;
    }

    @PostMapping("/create")
    public User createUser (@RequestBody User user) {
        
        //guardar usuario en la bbdd
        
        user.setEmail(user.getEmail().toLowerCase());

        return user;
    }

    @GetMapping("/values")
    public Map<String,Object> getValues(@Value("${config.message}") String message) {
        
        Map<String,Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("message env", environment.getProperty("config.message"));
        json.put("code", code);
        json.put("code env", environment.getProperty("config.code", Integer.class));
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("valuesMapProduct", product);


        return json;

    }
    

}
