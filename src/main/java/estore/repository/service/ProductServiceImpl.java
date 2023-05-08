package estore.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estore.repository.Product;
import estore.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDAO;

	@Override
	public void create(Product item) {
		productDAO.save(item);
		
	}

	@Override
	public Product getById(Integer id) {
		
		return productDAO.getById(id);
	}

	@Override
	public List<Product> findAll() {
		
		return productDAO.findAll();
	}
	
	

}
