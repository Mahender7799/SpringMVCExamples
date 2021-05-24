package com.ibm.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);

	}

	
	
	
	public List<Product> getAllProducts() {

		return sessionFactory.getCurrentSession().createQuery("from Product")
				.list();
	}

	@Override
	public void deleteProduct(Integer product_id) {
		Product product = (Product) sessionFactory.getCurrentSession().load(
				Product.class, product_id);
		if (null != product) {
			this.sessionFactory.getCurrentSession().delete(product);
		}

	}

	public Product getProduct(int product_id) {
		return (Product) sessionFactory.getCurrentSession().get(
				Product.class, product_id);
	}

	@Override
	public Product updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return product;
	}




	@Override
	public List<Product> showSearchedProducts(String invoice_id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Product where invoice_id LIKE :id").setParameter("id", "%"+invoice_id+"%");
		List<Product> list = query.list();
		
		return list;
	}




	@Override
	public List<Product> showDateFilteredProducts(String startDate, String endDate) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date frmDate;
		Date enDate;
		List<Product> products = null;
		try {
			frmDate =format.parse(startDate);
			enDate = format.parse(endDate);
			products = sessionFactory.getCurrentSession()
			.createQuery("FROM Product AS c WHERE c.product_add_date BETWEEN :stDate AND :edDate ")
			.setParameter("stDate", startDate)
			.setParameter("edDate", endDate)
			.list();
		}catch(Exception e) {
			System.out.println(e);
		}
		return products;
	}




	@Override
	public List<Product> showCategoryFilteredProducts(String category) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Product where category LIKE :id").setParameter("id", "%"+category+"%");
		List<Product> list = query.list();
		
		return list;
	}
	
	

}