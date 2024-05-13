package com.jg.demo.jpa.repo;

import com.jg.demo.jpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
