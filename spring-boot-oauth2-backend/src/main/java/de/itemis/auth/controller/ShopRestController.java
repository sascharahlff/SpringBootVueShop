package de.itemis.auth.controller;

import java.io.IOException;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.itemis.auth.converter.OrderConverter;
import de.itemis.auth.domain.OrderDTO;
import de.itemis.auth.domain.jpa.Address;
import de.itemis.auth.domain.jpa.Product;
import de.itemis.auth.repository.AddressRepository;
import de.itemis.auth.repository.OrderRepository;
import de.itemis.auth.repository.ProductRepository;
import de.itemis.auth.service.OrderService;

@RestController
@RequestMapping("/secured")
public class ShopRestController {
	private static final String ADDRESS_PATH = "/address";
	private static final String PRODUCTS_PATH = "/products";
	private static final String ORDER_PATH = "/order";

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderService orderService;

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

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = ORDER_PATH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody boolean saveOrder(@RequestParam("order") String order) {
		return orderService.saveOrder(order);
	}
}
