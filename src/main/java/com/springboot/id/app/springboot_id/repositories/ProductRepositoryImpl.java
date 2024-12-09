package com.springboot.id.app.springboot_id.repositories;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.springboot.id.app.springboot_id.models.Product;

@Primary
@Repository
public class ProductRepositoryImpl implements ProductRepositoryInterface {

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = List.of(
                new Product(1L, "Product 1", 100L),
                new Product(2L, "Product 2", 200L),
                new Product(3L, "Product 3", 300L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }
    
    @Override
    public Product findById(Long id) {
        return data.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

}
