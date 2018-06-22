package de.itemis.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.itemis.auth.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Product findByName(String name);
	
	@Query(value = "SELECT id, product_no, name, description, image, price FROM products WHERE LOWER(name) LIKE LOWER(concat('%', :search,'%'))", nativeQuery=true)
	List<Product> search(@Param("search") String search);
}
