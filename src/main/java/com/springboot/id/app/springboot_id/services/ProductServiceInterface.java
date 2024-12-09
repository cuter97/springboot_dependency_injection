package com.springboot.id.app.springboot_id.services;

import java.util.List;

import com.springboot.id.app.springboot_id.models.Product;

public interface ProductServiceInterface {
    List<Product> findAll();
    Product findById(Long id);
}
