package com.ibm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int product_id;

	@Column
	private String product_name;

	@Column
	private String category;

	@Column
	private String invoice_id;

	@Column
	private String price;
	
	@Column
	private String product_add_date;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(String invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProduct_add_date() {
		return product_add_date;
	}

	public void setProduct_add_date(String product_add_date) {
		this.product_add_date = product_add_date;
	}

	
	
	
}
