package de.itemis.auth.service;

import java.util.List;

import de.itemis.auth.domain.jpa.Product;

public interface ProductService {
	Product findByName(String name);
	List<Product> search(String search);
}
