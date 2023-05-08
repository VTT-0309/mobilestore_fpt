package estore.repository.service;

import java.util.List;

import estore.repository.Product;

public interface ProductService {

	void create(Product item);

	Product getById(Integer id);

	List<Product> findAll();

	

}
