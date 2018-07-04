export default class AddressVO {
	constructor(id, name, street, zipCode, city) {
		this.id = id;
		this.name = name;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}

	getId() {
		return this.id;
	}

	setId(id) {
		this.id = id;
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
}