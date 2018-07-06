package de.itemis.auth.repository;

import org.springframework.data.repository.CrudRepository;

import de.itemis.auth.domain.jpa.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String name);
}
