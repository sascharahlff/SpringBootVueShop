package de.itemis.auth.domain;

public class Order {
	private Long userId;
	private Long addressId;
	private Product[] products;
	
	// Default constructor required for jackson object mapper
	public Order() {
		
	}
	
	public Order(final Long userId, final Long addressId) {
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

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}
}
