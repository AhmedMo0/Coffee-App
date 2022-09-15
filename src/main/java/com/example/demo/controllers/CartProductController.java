package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.CartProduct;
import com.example.demo.domain.ItemDto;
import com.example.demo.domain.Product;
import com.example.demo.Service.CartProductService;

@RestController
@RequestMapping("/cartproduct")
@CrossOrigin(origins = "*")
public class CartProductController {
	@Autowired
	CartProductService cartProductService;

	
	@Cacheable(value = "cartProducts")
	@GetMapping(value = { "", "/" })
	public List<CartProduct> getAllProducts() {
		try {
			
			return cartProductService.getAllProducts();
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@Cacheable(value = "cartProducts", key = "#userId")
	@GetMapping(value = "/{userId}")
	public List<CartProduct> getCart(@PathVariable long userId) {
		try {			
			
			return cartProductService.getCart(userId);
			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/cardtotal/{cardId}")
	public int getCardTotal(@PathVariable int cardId) {
		return cartProductService.getCardTotal(cardId);
	}

	@CacheEvict(value= "cartProducts", allEntries = true)
	@PostMapping(value = {"", "/addProductToCart"})
	public ResponseEntity<?> addItemToCart(@RequestBody ItemDto item) {
		try{
			cartProductService.addItemToCart(item);
			
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@CacheEvict(value= "cartProducts", allEntries = true)
	@PostMapping(value = {"/addAllProducts"})
	public ResponseEntity<?> addAllItemToCart(@RequestBody List<ItemDto> items) {
		try {
			cartProductService.addAllItemToCart(items);
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@CacheEvict(value= "cartProducts", allEntries = true)
	@DeleteMapping(value = {"/deleteproduct/{cartProductId}", "/buyproduct/{cartProductId}"})
	public ResponseEntity<?> deleteProductFromCart(@PathVariable int cartProductId) {
		try {
			cartProductService.deleteProductFromCart(cartProductId);
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@CacheEvict(value= "cartProducts", allEntries = true)
	@DeleteMapping(value = {"/deleteCart/{userId}", "/buy/{userId}"})
	public ResponseEntity<?> deleteCart(@PathVariable Long userId) {
		try {
			cartProductService.deleteCart(userId);	
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	

}
