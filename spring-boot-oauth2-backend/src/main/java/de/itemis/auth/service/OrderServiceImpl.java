package de.itemis.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.itemis.auth.converter.OrderConverter;
import de.itemis.auth.converter.OrderItemConverter;
import de.itemis.auth.domain.OrderDTO;
import de.itemis.auth.domain.OrderItemDTO;
import de.itemis.auth.domain.jpa.Order;
import de.itemis.auth.domain.jpa.OrderItem;
import de.itemis.auth.repository.OrderItemsRepository;
import de.itemis.auth.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemsRepository orderItemRepository;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	OrderConverter orderConverter;

	@Autowired
	OrderItemConverter orderItemConverter;

	@Override
	@Transactional
	public boolean saveOrder(String json) {
		try {
			// Convert JSON to OrderDTO
			OrderDTO dto = mapper.readValue(json, OrderDTO.class);

			if (dto != null) {
				Order order = orderConverter.convert(dto);
				OrderItemDTO[] items = dto.getItems();

				if (order != null) {
					orderRepository.save(order);

					// Save order positions
					if (items != null) {
						for (OrderItemDTO item : items) {
							OrderItem orderItem = orderItemConverter.convert(item);
							orderItem.setOrder(order);

							if (orderItem != null) {
								orderItemRepository.save(orderItem);
							}
						}
					}
				}
			}

			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
