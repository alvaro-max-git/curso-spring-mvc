package com.max.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.springboot.di.app.springboot_di.models.Product;
import com.max.springboot.di.app.springboot_di.services.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductServiceImpl service = new ProductServiceImpl();

    @GetMapping("/products")
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.findById(id);
    }

}
