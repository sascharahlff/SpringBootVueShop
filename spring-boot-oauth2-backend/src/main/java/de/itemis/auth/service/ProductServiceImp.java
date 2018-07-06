package de.itemis.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.itemis.auth.domain.jpa.Product;
import de.itemis.auth.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product findByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> search(String search) {
		List<Product> products = new ArrayList<Product>();

		return products;
	}
}
