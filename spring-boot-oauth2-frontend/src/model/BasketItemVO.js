export default class BasketItem {
	constructor(id, item, quantity) {
		this.id = id;
		this.item = item;
		this.quantity = quantity;
	}

	getId() {
		return this.id;
	}

	setId(id) {
		this.id = id;
	}

	getItem() {
		return this.item;
	}

	setItem(item) {
		this.item = item;
	}

	getQuantity() {
		return this.quantity;
	}

	setQuantity(quantity) {
		this.quantity = quantity;
	}

	addQuantity(newQuantity) {
		this.quantity += newQuantity;
	}
}