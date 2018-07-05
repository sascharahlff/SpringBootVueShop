export default class AddressVO {
	constructor(id, name, street, zipCode, city, preferredAddress) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.preferredAddress = preferredAddress;
	}

	getId() {
		return this.id;
	}

	setId(id) {
		this.id = id;
	}

	getUserId() {
		return this.userId;
	}

	setUserId(userId) {
		this.userId = userId;
	}

	getName() {
		return this.name;
	}

	setName(name) {
		this.name = name;
	}

	getStreet() {
		return this.street;
	}

	setStreet(street) {
		this.street = street;
	}

	getZipCode() {
		return this.zipCode;
	}

	setZipCode(zipCode) {
		this.zipCode = zipCode;
	}
	
	getCity() {
		return this.city;
	}

	setCity(city) {
		this.city = city;
	}

	getPreferredAddress() {
		return this.preferredAddress;
	}

	setPreferredAddress(preferredAddress) {
		this.preferredAddress = preferredAddress;
	}
}