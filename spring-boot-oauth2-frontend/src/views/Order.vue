<template>
	<div class="container">
		<div v-if="error !== ''" class="alert alert-danger" role="alert">{{ error }}</div>
		<div class="form-group">
			<label for="foo">Adressauswahl</label>
			<div id="foo">
				<cart-item v-for="item in this.cartItems" v-bind:key="item.getId()" v-bind:cartItem="item"></cart-item>
			</div>
		</div>
		<div class="form-group">
			<label for="cmdUserAddress">Versandadresse</label>
			<select id="cmdUserAddress" class="form-control">
				<option v-for="address in this.addressList" v-bind:key="address.id" :selected="address.getPreferredAddress()">{{ address.getName() }} {{ address.getPreferredAddress() }}</option>
			</select>
		</div>
	</div>
</template>

<script>
import AddressVO from '../model/AddressVO.js';
import CartItem from './CartItem.vue'
import service from '../service'
import store from '../store';

export default {
	data() {
		return {
			error: "",
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
		getAddresses: function() {
			if (this.addressList.length == 0) {
				var sessionToken = localStorage.getItem("sessionToken");

				if (sessionToken != undefined) {
					var self = this;
					service.getAddressList(1, sessionToken)
					.then((response) => {
						var items = [];

						if (response != undefined) {
							response.data.forEach(element => {
								var addressVO = new AddressVO(element.id, element.name, element.street, element.zipCode, element.city, element.preferredAddress);
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
		}
	}
}
</script>