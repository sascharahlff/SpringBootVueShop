package de.itemis.auth.service;

import de.itemis.auth.domain.Product;

public interface ProductService {
	Product findByName(String name);
}
