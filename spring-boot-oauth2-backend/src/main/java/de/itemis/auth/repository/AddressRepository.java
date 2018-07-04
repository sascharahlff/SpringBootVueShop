package de.itemis.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.itemis.auth.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
	@Query(value = "SELECT id, name, street, zipCode, city " 
			+ "FROM address "
			+ "WHERE user_id = :userId", nativeQuery = true)
	List<Address> getUserAddressList(@Param("userId") String userId);
}
