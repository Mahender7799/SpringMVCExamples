package com.ibm.DAO;

import java.util.List;

import com.ibm.model.Product;

public interface ProductDAO {

	public void addProduct(Product product);

	public List<Product> getAllProducts();

	public void deleteProduct(Integer product_id);

	public Product updateProduct(Product product);

	public Product getProduct(int product_id);
	
	public List<Product> showSearchedProducts(String invoice_id);
	
	public List<Product> showDateFilteredProducts(String startDate, String endDate);
	
	public List<Product> showCategoryFilteredProducts(String category);
}
