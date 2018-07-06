package de.itemis.auth.repository;

import org.springframework.data.repository.CrudRepository;

import de.itemis.auth.domain.jpa.OrderItem;

public interface OrderItemsRepository extends CrudRepository<OrderItem, Long> {
}
