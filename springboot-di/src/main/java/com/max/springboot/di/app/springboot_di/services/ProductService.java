package com.max.springboot.di.app.springboot_di.services;

import java.util.List;

import com.max.springboot.di.app.springboot_di.models.Product;
import com.max.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    //los mismos métodos que en repositorio, pero contiene lógica de negocio,
    //trabaja con los datos.
    //también podríamos comunicarnos con una API externa

    private ProductRepository repository = new ProductRepository();

    /*
     * Añade impuesto, por 
     */

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTaxed = p.getPrice()*1.25;
            p.setPrice(priceTaxed.longValue());
            return p;
        }).toList(); //lista inmodificable. Si la queremos modificable, usar .collect(Collectors.toList())
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

}
