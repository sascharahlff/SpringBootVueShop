package de.itemis.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.itemis.auth.domain.Address;
import de.itemis.auth.domain.Product;
import de.itemis.auth.repository.AddressRepository;
import de.itemis.auth.repository.ProductRepository;

@RestController
@RequestMapping("/secured")
public class ShopRestController {
	private static final String ADDRESS_PATH = "/address";
	private static final String PRODUCTS_PATH = "/products";

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ProductRepository productRepository;

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = ADDRESS_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<Address> getAddresses(@RequestParam("userid") Long userId) {
		return addressRepository.getUserAddressList(userId);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = PRODUCTS_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<Product> getProducts(@RequestParam("search") String search) {
		return productRepository.search(search);
	}
}
