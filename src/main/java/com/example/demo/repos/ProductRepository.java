package com.example.demo.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Product findByproductId(int productId);
	
	@Query(value="select * from product where product_category=?1",nativeQuery = true)
	List<Product> getProductWithCategory(String category);
	
	@Query(value="select * from cart_product where card_id=?1",nativeQuery = true)
	List<Product>getProductWithCardId(int cardId);
	
	@Modifying
	@Transactional
	@Query(value="update product set product_name=?1,product_price=?2,product_sugar_spoon=?3,bought_items_count=?4,product_stock_quantity=?5,product_category=?6 where product_id=?7",nativeQuery = true)
	public int updateProduct(String productName,int productPrice,int productSugarSpoon,int boughtItemsCount,int productStockQuantity,String productCategory, int productId);
	
	@Modifying
	@Transactional
	@Query(value="update product set product_name=?1 where product_id=?2",nativeQuery = true)
	public int updateProductName(String productName, int productId);
	
	@Modifying
	@Transactional
	@Query(value="update product set is_added_to_cart=?1 where product_id=?2",nativeQuery = true)
	int updateProductAddToCart(boolean isAddedToCart, int productId);
	
}
