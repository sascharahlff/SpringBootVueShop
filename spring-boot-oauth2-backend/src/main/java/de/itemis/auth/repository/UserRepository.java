package de.itemis.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import de.itemis.auth.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	UserDetails findByUsername(String name);
}
