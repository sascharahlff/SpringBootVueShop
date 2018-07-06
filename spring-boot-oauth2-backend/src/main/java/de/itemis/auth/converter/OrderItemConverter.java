package de.itemis.auth.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import de.itemis.auth.domain.OrderItemDTO;
import de.itemis.auth.domain.jpa.OrderItem;
import de.itemis.auth.domain.jpa.Product;

@Component
public class OrderItemConverter implements Converter<OrderItemDTO, OrderItem> {
	@Override
	public OrderItem convert(OrderItemDTO dto) {
		OrderItem orderItem = new OrderItem();

		if (dto != null) {
			Product product = new Product();
			product.setId(dto.getProductId());
			orderItem.setProduct(product);
			orderItem.setPrice(dto.getPrice());
		}

		return orderItem;
	}
}
