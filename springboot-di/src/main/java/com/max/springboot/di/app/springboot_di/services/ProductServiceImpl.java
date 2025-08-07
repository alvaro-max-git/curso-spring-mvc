package com.max.springboot.di.app.springboot_di.services;

import java.util.List;

import com.max.springboot.di.app.springboot_di.models.Product;
import com.max.springboot.di.app.springboot_di.repositories.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService{

    //los mismos métodos que en repositorio, pero contiene lógica de negocio,
    //trabaja con los datos.
    //también podríamos comunicarnos con una API externa

    private ProductRepositoryImpl repository = new ProductRepositoryImpl();

    /*
     * Añade impuesto
     */

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTaxed = p.getPrice()*1.25;
            //Product newProd = new Product(p.getId(), p.getName(), priceTaxed.longValue());
            Product newProd = (Product)p.clone();
            newProd.setPrice(priceTaxed.longValue());
            return newProd;
        }).toList(); //lista inmodificable. Si la queremos modificable, usar .collect(Collectors.toList())
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
