package de.itemis.auth.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import de.itemis.auth.domain.OrderDTO;
import de.itemis.auth.domain.jpa.Address;
import de.itemis.auth.domain.jpa.Order;
import de.itemis.auth.domain.jpa.User;

@Component
public class OrderConverter implements Converter<OrderDTO, Order> {
	@Override
	public Order convert(OrderDTO dto) {
		Order order = new Order();

		if (dto != null) {
			User user = new User();
			user.setId(dto.getUserId());
			order.setUser(user);
			
			Address address = new Address();
			address.setId(dto.getAddressId());
			order.setAddress(address);
		}

		return order;
	}
}
