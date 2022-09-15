package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int productId;
	public String productName;
	public int productPrice;
	public String ProductImage;
	public int productSugarSpoon;
	
	public boolean isAddedToCart;
	public int boughtItemsCount;
	public int productStockQuantity;
	 
	public String ProductCategory;
	
	
	
	/*
	 * @OneToMany(mappedBy = "product") public List<CartProduct> cartProduct;
	 */
	
}
