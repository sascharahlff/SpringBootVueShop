export default class BasketItem {
	constructor(item, quantity) {
		this.item = item;
		this.quantity = quantity;
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