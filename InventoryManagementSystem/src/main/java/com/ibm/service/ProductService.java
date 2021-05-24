package com.ibm.service;

import java.util.List;

import com.ibm.model.Product;



public interface ProductService {
	public void newProduct(Product product);

	public List<Product> showAllProducts();

	public void removeProduct(Integer product_id);

	public Product viewProduct(int product_id);

	public Product modifyProduct(Product product);
	
	public List<Product> displaySearchedProducts(String invoice_id);
	
	public List<Product> displayDateFilteredProducts(String startDate, String endDate);
	
	public List<Product> displayCategoryFilteredProducts(String category);
}
