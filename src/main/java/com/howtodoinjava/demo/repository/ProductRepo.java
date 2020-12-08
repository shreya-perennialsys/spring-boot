package com.howtodoinjava.demo.repository;


import com.howtodoinjava.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Integer> {
}
