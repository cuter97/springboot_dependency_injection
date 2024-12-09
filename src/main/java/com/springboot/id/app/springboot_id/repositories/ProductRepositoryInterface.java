package com.springboot.id.app.springboot_id.repositories;

import java.util.List;

import com.springboot.id.app.springboot_id.models.Product;

public interface ProductRepositoryInterface {
    List<Product> findAll();
    Product findById(Long id);
}
