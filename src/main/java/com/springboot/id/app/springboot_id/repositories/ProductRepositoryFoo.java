package com.springboot.id.app.springboot_id.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.id.app.springboot_id.models.Product;

@Repository
public class ProductRepositoryFoo implements ProductRepositoryInterface {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Product 1", 100L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Product 1", 100L);
    }

}
