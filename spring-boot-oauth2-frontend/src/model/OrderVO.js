export default class OrderVO {
	
	constructor(userId, addressId) {
		this.userId = userId;
		this.addressId = addressId;
		this.items = [];
	}
	
	addItem(item) {
		this.items.push(item);
	}
}