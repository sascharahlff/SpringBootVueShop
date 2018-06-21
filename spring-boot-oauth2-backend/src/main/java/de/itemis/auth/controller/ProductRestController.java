package de.itemis.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.itemis.auth.domain.Product;
import de.itemis.auth.repository.ProductRepository;

@RestController
@RequestMapping("/secured")
public class ProductRestController {
	private static final String PRODUCTS_PATH = "/products";

	@Autowired
	ProductRepository productRepository;

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = PRODUCTS_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<Product> getProducts(@PathVariable("search") String search) {
		List<Product> p = productRepository.search(search);
		return p; //productRepository.search(search);
		//return productRepository.findAll();
	}
}
