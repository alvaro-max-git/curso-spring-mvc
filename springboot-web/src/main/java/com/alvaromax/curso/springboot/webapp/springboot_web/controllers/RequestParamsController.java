package com.alvaromax.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaromax.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {


    //aquí devuelve el objeto si llamamos a http://localhost:8090/api/params/foo?mensaje=Hola%20que%20tal
    //si omitimos name, en la ruta se tiene que llamar como se llame la String, el atributo (en este caso iguales, se suele hacer así)

    @GetMapping("/foo")
    public ParamDto foo (@RequestParam(required=false, defaultValue = "sin mensaje", name = "message") String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }


    //tienen que ser datos básicos, no objetos. Para enviar objetos en el JSON (request body)
    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) {
        
        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    //de forma nativa, con HttpServletRequest
    //nos da mejor control del dato (fijarse en el try-catch), en el anterior si code no es válido peta.

    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request) {
        
        ParamDto params = new ParamDto();
        Integer code = 0;

        try {
           code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }

        params.setCode(code);
        params.setMessage(request.getParameter("message"));

        return params;
    }
    
    

    
    

}
