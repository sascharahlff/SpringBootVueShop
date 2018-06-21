package de.itemis.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.itemis.auth.converter.UserDetailsConverter;
import de.itemis.auth.domain.User;
import de.itemis.auth.domain.UserDetails;
import de.itemis.auth.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserDetailsConverter converter;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		return converter.convert(user);
	}
}
