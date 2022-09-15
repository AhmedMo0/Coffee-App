package com.example.demo.domain;

import java.io.Serializable;

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
public class Product implements Serializable{
	
	public static final long serialVersionUID = -2228784815938588107L;

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
	
	
}
