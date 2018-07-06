package de.itemis.auth.domain;

public class OrderDTO {
	private Long userId;
	private Long addressId;
	private OrderItemDTO[] items;
	
	// Default constructor required for jackson object mapper
	public OrderDTO() {
		super();
	}
	
	public OrderDTO(final Long userId, final Long addressId) {
		this.userId = userId;
		this.addressId = addressId;
	}
		
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public OrderItemDTO[] getItems() {
		return items;
	}

	public void setItems(OrderItemDTO[] items) {
		this.items = items;
	}
}
