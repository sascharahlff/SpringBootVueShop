package de.itemis.auth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.itemis.auth.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Product findByName(String name);
	
	
	List<Product> search(String search);
}
