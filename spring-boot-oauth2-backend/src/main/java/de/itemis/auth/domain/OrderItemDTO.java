package de.itemis.auth.domain;

public class OrderItemDTO {
	private Long productId;
	private Double price;
	
	// Default constructor required for jackson object mapper
	public OrderItemDTO() {
		super();
	}
	
	public OrderItemDTO(final Long productId, final Double price) {
		this.productId = productId;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
