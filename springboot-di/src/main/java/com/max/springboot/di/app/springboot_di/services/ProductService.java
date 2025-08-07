package com.max.springboot.di.app.springboot_di.services;

import java.util.List;

import com.max.springboot.di.app.springboot_di.models.Product;

public interface ProductService {

    List<Product> findAll ();
    public Product findById(Long id);

}
