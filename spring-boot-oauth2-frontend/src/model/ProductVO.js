export default class ProductVO {
	constructor(id, productNo, name, description, image, price) {
		this.id = id;
		this.productNo = productNo
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
	}

	getId() {
		return this.id;
	}

	setId(id) {
		this.id = id;
	}

	getProductNo() {
		return this.productNo;
	}

	setProductNo(productNo) {
		this.productNo = productNo;
	}
	
	getName() {
		return this.name;
	}

	setName(name) {
		this.name = name;
	}

	getDescription() {
		return this.description;
	}

	setDescription(description) {
		this.description = description;
	}

	getImage() {
		return this.image;
	}

	setImage(image) {
		this.image = image;
	}
	
	getPrice() {
		return this.price;
	}

	setPrice(price) {
		this.price = price;
	}
}