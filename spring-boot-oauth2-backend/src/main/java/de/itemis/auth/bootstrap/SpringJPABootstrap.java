package de.itemis.auth.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import de.itemis.auth.domain.Address;
import de.itemis.auth.domain.Product;
import de.itemis.auth.domain.User;
import de.itemis.auth.repository.ProductRepository;
import de.itemis.auth.repository.UserRepository;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		createUsers();
		createProducts();
	}

	private void createUsers() {
		List<Address> addresses = new ArrayList<>();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

		User user = new User();
		user.setUsername("foo");
		user.setPassword("bar");
		user.setEnabled(true);
		user.setPasswordHash(encoder.encode("bar"));

		addresses = new ArrayList<>();
		Address address = new Address();
		address.setUser(user);
		address.setStreet("Speersort 10");
		address.setZipCode("20095");
		address.setCity("Hamburg");
		address.setPreferredAddress(true);
		addresses.add(address);

		address = new Address();
		address.setUser(user);
		address.setStreet("Schuhmacherort 2");
		address.setZipCode("25746");
		address.setCity("Heide");
		address.setPreferredAddress(false);
		addresses.add(address);

		user.setAddresses(addresses);
		userRepository.save(user);

		user = new User();
		user.setUsername("srahlff");
		user.setPassword("password");
		user.setEnabled(true);
		user.setPasswordHash(encoder.encode("password"));

		addresses = new ArrayList<>();
		address = new Address();
		address.setUser(user);
		address.setStreet("Osterende 1A");
		address.setZipCode("25881");
		address.setCity("Tating");
		address.setPreferredAddress(true);
		addresses.add(address);

		user.setAddresses(addresses);
		userRepository.save(user);
	}

	private void createProducts() {
		Product product = new Product();
		product.setProductNo("B0747LZTM8");
		product.setName("Anki Cozmo");
		product.setDescription("Ein charmanter und intelligenter Roboter, der seine Umwelt erforscht, sich erinnert und auf seine Umwelt sowie auf Sie reagiert.");
		product.setImage("cozmo-01.png");
		product.setPrice(207.89);
		productRepository.save(product);

		product = new Product();
		product.setProductNo("B074ZPSRQR");
		product.setName("Anki Cozmo + Tragetasche");
		product.setDescription("Ein charmanter und intelligenter Roboter mit Tragetasche, der seine Umwelt erforscht, sich erinnert und auf seine Umwelt sowie auf Sie reagiert.");
		product.setImage("cozmo-02.png");
		product.setPrice(235.438);
		productRepository.save(product);
	}
}
