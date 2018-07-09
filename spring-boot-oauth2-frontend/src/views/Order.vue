<template>
	<div class="container">
		<div v-if="error !== ''" class="alert alert-danger" role="alert">{{ error }}</div>
		<div class="form-group">
			<label class="orderAddressLabel" for="userAddresses">Versandadresse</label>
			<div id="userAddresses" v-for="address in this.addressList" v-bind:key="address.id">
				<div class="custom-control custom-radio">
					<input type="radio" :id="'address_'+address.getId()" name="address" v-model="addressId" :checked="address.getPreferredAddress()" :value="address.getId()">
					<label :for="'address_'+address.getId()">{{ address.getName() }} - {{address.getStreet()}}, {{address.getZipCode()}} {{address.getCity()}} </label>
				</div>
			</div>
		</div>
		
		<div>
			<label class="orderAddressLabel" for="userCartItems">Artikel</label>
			<table class="table">
				<thead>
				<tr>
					<th scope="col">Nr.</th>
					<th scope="col">Produkt</th>
					<th class="text-right" scope="col">Preis</th>
					<th class="text-right" scope="col">Menge</th>
				</tr>
				</thead>
				<tbody>
					<cart-item v-for="item in this.cartItems" v-bind:key="item.getId()" v-bind:cartItem="item"></cart-item>
				</tbody>
			</table>
		</div>
		
		<div class="form-group">
			<button class="btn btn-primary" v-on:click="submit">Jetzt kaufen</button>			
		</div>
	</div>
</template>

<script>
import AddressVO from '../model/AddressVO.js';
import CartItem from './CartItem.vue'
import service from '../service'
import store from '../store';
import router from '../router/index.js';

export default {
	data() {
		return {
			error: "",
			addressId: null,
			addressList: [],
			cartItems: store.state.cartItems
		}
	},
	created: function() {
		this.getAddresses();
	},
	components: {
		'cart-item': CartItem,
	},
	methods: {
		submit: function() {
			var userId = this.getUserId();
			var sessionToken = this.getSessionToken();
			var self = this;

			if (userId != null && sessionToken != null) {
				service.saveOrder(userId, this.addressId, this.cartItems, sessionToken)
				.then((response) => {
					if (response.data == true) {
						// Show success message in Product.vue
						sessionStorage.setItem("successInfo", "Ihre Bestellung wurde aufgenommen.");
						store.commit("clear");
						router.push("/products");
					}
					else {
						self.error = "Beim Speichern Ihrer Bestellung ist ein Fehler aufgetreten, senden Sie den Warenkorb erneut ab."
					}
				})
			}
		},
		getAddresses: function() {
			if (this.addressList.length == 0) {
				var userId = this.getUserId();
				var sessionToken = this.getSessionToken();
				var self = this;

				if (userId != null && sessionToken != null) {
					service.getAddressList(userId, sessionToken)
					.then((response) => {
						var items = [];

						if (response != undefined) {
							response.data.forEach(element => {
								var addressVO = new AddressVO(element.id, element.name, element.street, element.zipCode, element.city, element.preferredAddress);

								// Set preferred user address
								if (element.preferredAddress) {
									this.addressId = element.id;
								}

								items.push(addressVO);
							});
						}
						else {
							self.error = "Keine Daten empfangen.";
						}

						this.addressList = items;
					}).catch ((e) => {
						// Token is expired => get new token with refresh-token and restart rest call
						if (e.response.data != undefined && e.response.data.error != undefined && e.response.data.error == "invalid_token") {
							service.refreshToken(this.tokenRefreshCallback);
						}
						// Other error
						else {
							self.error = "Der Service ist nicht erreichbar."
						}
					});
				}
			}
		},
		tokenRefreshCallback: function() {
			// Restart getAdresses() with new token
			this.getAddresses();
		},
		getUserId() {
			var userId = sessionStorage.getItem("userId");
			
			if (userId == null) {
				this.error = "Keine User-Session gefunden, bitte loggen Sie sich erneut ein.";
			}

			return userId;
		},
		getSessionToken() {
			var token = localStorage.getItem("sessionToken");

			if (token == null) {
				this.error = "Kein Session-Token gefunden, bitte loggen Sie sich erneut ein.";
			}

			return token;
		}
	}
}
</script>