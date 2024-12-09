package com.springboot.id.app.springboot_id.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springboot.id.app.springboot_id.exceptions.ProductNotFoundException;
import com.springboot.id.app.springboot_id.models.Product;
import com.springboot.id.app.springboot_id.repositories.ProductRepositoryInterface;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

    @Autowired
    private Environment env;
    
    @Autowired
    private ProductRepositoryInterface repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(product -> {
            
            @SuppressWarnings("null")
            Double priceImp = product.getPrice() * env.getProperty("config.price.tax", Double.class);
            Product newProduct = (Product) product.clone();

            newProduct.setPrice(priceImp.longValue());
            
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        Product product = repository.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
        return product;
    }

}
