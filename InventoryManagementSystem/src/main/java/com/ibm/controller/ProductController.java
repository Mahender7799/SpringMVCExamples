package com.ibm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.model.Product;
import com.ibm.service.ProductService;



@Controller
public class ProductController {

	public ProductController() {
		System.out.println("ProductController()");
	}

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/")
	public ModelAndView listProduct(ModelAndView model) throws IOException {
		List<Product> listProduct = productService.showAllProducts();
		model.addObject("listProduct", listProduct);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView newProduct(ModelAndView model) {
		Product product = new Product();
		model.addObject("product", product);
		model.setViewName("addProduct");
		return model;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute Product product) {
		if (product.getProduct_id() == 0) { 
			
			productService.newProduct(product);
		} else {
			productService.modifyProduct(product);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(HttpServletRequest request) {
		int productId = Integer.parseInt(request.getParameter("id"));
		productService.removeProduct(productId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(HttpServletRequest request) {
		System.out.println("\\n\\n\\n"+ Integer.parseInt(request.getParameter("id")));
		int productId = Integer.parseInt(request.getParameter("id"));
		Product product = productService.viewProduct(productId);
		ModelAndView model = new ModelAndView("addProduct");
		model.addObject("product", product);

		return model;
	}
	
	@RequestMapping(value="/searchProduct")
	public ModelAndView searchProduct(ModelAndView model, @RequestParam("query")String invoice_id) {
		List<Product> list = productService.displaySearchedProducts(invoice_id);
		
		model.addObject("list",list);
		model.setViewName("searched");
		return model;
	}
	
	@RequestMapping(value="/filterByDate")
	public ModelAndView filterByDate(ModelAndView model, @RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate) {
		List<Product> list = productService.displayDateFilteredProducts(startDate, endDate);
		
		model.addObject("list",list);
		model.setViewName("dateFilter");
		return model;
	}
	
	@RequestMapping(value="/filterByCategory")
	public ModelAndView filterByCategory(ModelAndView model, @RequestParam("category")String category) {
		List<Product> list = productService.displayCategoryFilteredProducts(category);
		
		model.addObject("list",list);
		model.setViewName("categoryFilter");
		return model;
	}

}