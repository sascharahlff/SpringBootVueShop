package de.itemis.auth.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import de.itemis.auth.domain.jpa.Address;
import de.itemis.auth.domain.jpa.Order;
import de.itemis.auth.domain.jpa.OrderItem;
import de.itemis.auth.domain.jpa.Product;
import de.itemis.auth.domain.jpa.User;
import de.itemis.auth.repository.AddressRepository;
import de.itemis.auth.repository.OrderItemsRepository;
import de.itemis.auth.repository.OrderRepository;
import de.itemis.auth.repository.ProductRepository;
import de.itemis.auth.repository.UserRepository;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	UserRepository userRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemsRepository orderItemRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		createUsers();
		// createProducts();
	}

	private void createUsers() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

		User user = new User();
		user.setUsername("foo");
		user.setPassword("bar");
		user.setEnabled(true);
		user.setPasswordHash(encoder.encode("bar"));
		userRepository.save(user);

		Address address1 = new Address();
		address1.setUser(user);
		address1.setName("Biff Tannen");
		address1.setStreet("Speersort 10");
		address1.setZipCode("20095");
		address1.setCity("Hamburg");
		address1.setPreferredAddress(false);
		addressRepository.save(address1);

		Address address2 = new Address();
		address2.setUser(user);
		address2.setName("Marty McFly");
		address2.setStreet("Schuhmacherort 2");
		address2.setZipCode("25746");
		address2.setCity("Heide");
		address2.setPreferredAddress(true);
		addressRepository.save(address2);

		Product product1 = new Product();
		product1.setProductNo("B0747LZTM8");
		product1.setName("Anki Cozmo");
		product1.setDescription(
				"Ein charmanter und intelligenter Roboter, der seine Umwelt erforscht, sich erinnert und auf seine Umwelt sowie auf Sie reagiert.");
		product1.setImage("cozmo-01.png");
		product1.setPrice(207.89);
		productRepository.save(product1);

		Product product2 = new Product();
		product2.setProductNo("B074ZPSRQR");
		product2.setName("Anki Cozmo + Tragetasche");
		product2.setDescription(
				"Ein charmanter und intelligenter Roboter mit Tragetasche, der seine Umwelt erforscht, sich erinnert und auf seine Umwelt sowie auf Sie reagiert.");
		product2.setImage("cozmo-02.png");
		product2.setPrice(235.438);
		productRepository.save(product2);

		Product product3 = new Product();
		product3.setProductNo("foo");
		product3.setName("blub");
		product3.setDescription("bla");
		product3.setImage("cozmo-02.png");
		product3.setPrice(123.45);
		productRepository.save(product3);

		Order order = new Order();
		order.setUser(user);
		order.setAddress(address1);
		orderRepository.save(order);

		OrderItem item = new OrderItem();
		item.setProduct(product1);
		item.setPrice(1.23);
		item.setOrder(order);
		orderItemRepository.save(item);

		item = new OrderItem();
		item.setProduct(product2);
		item.setPrice(2.34);
		item.setOrder(order);
		orderItemRepository.save(item);

		order = new Order();
		order.setUser(user);
		order.setAddress(address2);
		orderRepository.save(order);

		item = new OrderItem();
		item.setProduct(product3);
		item.setPrice(3.45);
		item.setOrder(order);
		orderItemRepository.save(item);
	}

	// private void createUsers() {
	// List<Address> addresses = new ArrayList<>();
	// BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
	//
	// User user = new User();
	// user.setUsername("foo");
	// user.setPassword("bar");
	// user.setEnabled(true);
	// user.setPasswordHash(encoder.encode("bar"));
	//
	// addresses = new ArrayList<>();
	// Address address = new Address();
	// address.setUser(user);
	// address.setName("Biff Tannen");
	// address.setStreet("Speersort 10");
	// address.setZipCode("20095");
	// address.setCity("Hamburg");
	// address.setPreferredAddress(false);
	// addresses.add(address);
	//
	// address = new Address();
	// address.setUser(user);
	// address.setName("Marty McFly");
	// address.setStreet("Schuhmacherort 2");
	// address.setZipCode("25746");
	// address.setCity("Heide");
	// address.setPreferredAddress(true);
	// addresses.add(address);
	//
	// user.setAddresses(addresses);
	// userRepository.save(user);
	//
	// user = new User();
	// user.setUsername("srahlff");
	// user.setPassword("password");
	// user.setEnabled(true);
	// user.setPasswordHash(encoder.encode("password"));
	//
	// addresses = new ArrayList<>();
	// address = new Address();
	// address.setName("Sascha Rahlff");
	// address.setUser(user);
	// address.setStreet("Osterende 1A");
	// address.setZipCode("25881");
	// address.setCity("Tating");
	// address.setPreferredAddress(true);
	// addresses.add(address);
	//
	// user.setAddresses(addresses);
	// userRepository.save(user);
	// }

	private void createProducts() {
		Product product = new Product();
		product.setProductNo("B0747LZTM8");
		product.setName("Anki Cozmo");
		product.setDescription(
				"Ein charmanter und intelligenter Roboter, der seine Umwelt erforscht, sich erinnert und auf seine Umwelt sowie auf Sie reagiert.");
		product.setImage("cozmo-01.png");
		product.setPrice(207.89);
		productRepository.save(product);

		product = new Product();
		product.setProductNo("B074ZPSRQR");
		product.setName("Anki Cozmo + Tragetasche");
		product.setDescription(
				"Ein charmanter und intelligenter Roboter mit Tragetasche, der seine Umwelt erforscht, sich erinnert und auf seine Umwelt sowie auf Sie reagiert.");
		product.setImage("cozmo-02.png");
		product.setPrice(235.438);
		productRepository.save(product);
	}
}
