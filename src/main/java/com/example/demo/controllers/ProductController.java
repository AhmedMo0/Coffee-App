package com.example.demo.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Product;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping(value = { "", "/" })
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(value = "/{id}")
	public Product getProductWithID(@PathVariable int id) {
		return productService.getProductWithID(id);
	}

	@GetMapping(value = "/cat/{category}")
	public List<Product> getProductWithCategory(@PathVariable String category) {
		return productService.getProductWithCategory(category);
	}

	@GetMapping(value = "/card/{cardId}")
	public List<Product> getProductWithCardId(@PathVariable int cardId) {
		return productService.getProductWithCardId(cardId);
	}

	@PostMapping(value = "/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addAll(product);
	}

	@PostMapping(value = "/addAll")
	public List<Product> addProduct(@RequestBody List<Product> products) {
		return productService.addAll(products);
	}

	@DeleteMapping(value = "/del/{id}")
	public String delProduct(@PathVariable int id) {
		return productService.delProduct(id);
	}

	@PutMapping(value = "/updateProduct")
	public Product updateProduct(@RequestBody Product nProduct) {
		return productService.updateProduct(nProduct);
	}

	@PutMapping(value = "/updateProductName")
	public Product updateProductName(@RequestBody Product nProduct) {
		return productService.updateProductName(nProduct);
	}

	@PutMapping(value = "/updateProductAddToCart")
	public Product updateProductAddToCart(@RequestBody Product nProduct) {
		return productService.updateProductAddToCart(nProduct);
	}
}