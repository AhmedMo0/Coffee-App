package com.example.demo.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Product;
import com.example.demo.repos.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductWithID(int productId) {
		return productRepository.findByproductId(productId);
	}

	public List<Product> getProductWithCategory(String category) {
		return productRepository.getProductWithCategory(category);
	}

	public List<Product> getProductWithCardId(int cardId) {
		return productRepository.getProductWithCardId(cardId);
	}

	public Product addAll(Product product) {
		return productRepository.save(product);
	}

	//Doesn't insert gher el name
	public List<Product> addAll(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public String delProduct(int id) {
		productRepository.deleteById(id);
		return "Done";
	}

	//msh msama3a fl esm
	public Product updateProduct(Product nProduct) {
		int x = productRepository.updateProduct(nProduct.productName, nProduct.productPrice, nProduct.productSugarSpoon,
				nProduct.boughtItemsCount, nProduct.productStockQuantity, nProduct.ProductCategory, nProduct.productId);
		return nProduct;
	}

	public Product updateProductName(Product nProduct) {
		int x = productRepository.updateProductName(nProduct.productName, nProduct.productId);
		return nProduct;
	}

	public Product updateProductAddToCart(Product nProduct) {
		int x = productRepository.updateProductAddToCart(nProduct.isAddedToCart, nProduct.productId);
		return nProduct;
	}

}
