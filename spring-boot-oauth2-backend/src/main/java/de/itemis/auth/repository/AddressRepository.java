package de.itemis.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.itemis.auth.domain.jpa.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
	@Query(value = "SELECT user_id, address_id, name, street, zip_code, city, preferred_address " 
			+ "FROM addresses "
			+ "WHERE user_id = :userid", nativeQuery = true)
	List<Address> getUserAddressList(@Param("userid") Long userId);
}
