package com.example.demo.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.Product;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	ProductService productService;

	
	@Cacheable(value = "products")
	@GetMapping(value = { "", "/" })
	public List<Product> getAllProducts() {
		try {
			return productService.getAllProducts();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	public Product getProductWithID(@PathVariable int id) {
		try {
			return productService.getProductWithID(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/cat/{category}")
	public List<Product> getProductWithCategory(@PathVariable String category) {
		try {
			return productService.getProductWithCategory(category);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/card/{cardId}")
	public List<Product> getProductWithCardId(@PathVariable int cardId) {
		try {
			return productService.getProductWithCardId(cardId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@CacheEvict(value= "products", allEntries = true)
	@PostMapping(value = "/add")
	public Product addProduct(@RequestBody Product product) {
		try {
			return productService.addAll(product);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@CacheEvict(value= "products", allEntries = true)
	@PostMapping(value = "/addAll")
	public List<Product> addProduct(@RequestBody List<Product> products) {
		try {
			return productService.addAll(products);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@CacheEvict(value= "products", allEntries = true, key = "#id")
	@DeleteMapping(value = "/del/{id}")
	public String delProduct(@PathVariable int id) {
		try {
			return productService.delProduct(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	
	@PutMapping(value = "/updateProduct")
	public Product updateProduct(@RequestBody Product nProduct) {
		try {
			return productService.updateProduct(nProduct);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateProductName")
	public Product updateProductName(@RequestBody Product nProduct) {
		try{
			return productService.updateProductName(nProduct);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateProductAddToCart")
	public Product updateProductAddToCart(@RequestBody Product nProduct) {
		try{
			return productService.updateProductAddToCart(nProduct);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
}
