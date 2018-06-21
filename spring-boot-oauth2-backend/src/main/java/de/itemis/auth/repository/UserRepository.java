package de.itemis.auth.repository;

import org.springframework.data.repository.CrudRepository;

import de.itemis.auth.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String name);
}
