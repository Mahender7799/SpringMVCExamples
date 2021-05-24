package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.DAO.ProductDAO;
import com.ibm.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	@Transactional
	public void newProduct(Product product) {
		productDAO.addProduct(product);
	}

	@Override
	@Transactional
	public List<Product> showAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	@Transactional
	public void removeProduct(Integer product_id) {
		productDAO.deleteProduct(product_id);
	}
	
	@Override
	
	public Product viewProduct(int product_id) {
		return productDAO.getProduct(product_id);
	}
	
	@Override
	public Product modifyProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.updateProduct(product);
	}
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public List<Product> displaySearchedProducts(String invoice_id) {
		// TODO Auto-generated method stub
		return productDAO.showSearchedProducts(invoice_id);
	}

	@Override
	public List<Product> displayDateFilteredProducts(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return productDAO.showDateFilteredProducts(startDate, endDate);
	}

	@Override
	public List<Product> displayCategoryFilteredProducts(String category) {
		// TODO Auto-generated method stub
		return productDAO.showCategoryFilteredProducts(category);
	}

}
