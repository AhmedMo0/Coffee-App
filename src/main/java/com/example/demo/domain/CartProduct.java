package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DynamicUpdate
@DynamicInsert
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProduct implements Serializable{
	
	public static final long serialVersionUID = -2228784815938588107L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int cartProductId;
	
	public int quantity;

	@ManyToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore
	public Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	public Product product;

	public CartProduct(int quantity, Cart cart, Product product) {
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}
}
