package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	

}
