package de.itemis.auth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.itemis.auth.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	List<Client> findAll();
	Client findByName(String name);
}
