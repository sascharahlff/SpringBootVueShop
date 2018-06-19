package de.itemis.auth.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import de.itemis.auth.domain.Client;
import de.itemis.auth.domain.User;
import de.itemis.auth.repository.ClientRepository;
import de.itemis.auth.repository.UserRepository;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	UserRepository userRepository;

	@Autowired
	ClientRepository clientRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		createUsers();
		createClients();
	}
	
	private void createUsers() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		
		User user = new User();
		user.setUsername("foo");
		user.setPassword("password");
		user.setAccountExpired(true);
		user.setAccountLocked(true);
		user.setCredentialsExpired(true);
		user.setEnabled(true);
		user.setPasswordHash(encoder.encode("password"));
		userRepository.save(user);

		user = new User();
		user.setUsername("blub");
		user.setPassword("foo");
		user.setAccountExpired(true);
		user.setAccountLocked(true);
		user.setCredentialsExpired(true);
		user.setEnabled(true);
		user.setPasswordHash(encoder.encode("foo"));
		userRepository.save(user);
	}
	
	private void createClients() {
		Client client = new Client();
		client.setName("Emmet Brown");
		clientRepository.save(client);
	}
}
