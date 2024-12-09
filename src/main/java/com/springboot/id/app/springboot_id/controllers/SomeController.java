package com.springboot.id.app.springboot_id.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.id.app.springboot_id.models.Product;
import com.springboot.id.app.springboot_id.services.ProductServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductServiceInterface service;
    
    @GetMapping("/products")
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }

}
