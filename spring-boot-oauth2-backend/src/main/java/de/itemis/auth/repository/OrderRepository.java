package de.itemis.auth.repository;

import org.springframework.data.repository.CrudRepository;

import de.itemis.auth.domain.jpa.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
