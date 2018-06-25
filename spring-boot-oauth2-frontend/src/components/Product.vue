<template>
	<div class="container">
		<div v-if="error != ''" class="alert alert-danger" role="alert">{{ error }}</div>
		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" v-bind:value="searchString" v-on:input="searchString = $event.target.value">
	
		<ul class="list-group mt-5">
			<product-item v-for="product in this.products" v-bind:key="product.id" v-bind:product="product"></product-item>
		</ul>
	</div>
</template>

<script>
import Vue from 'vue'
import auth from '../auth'
import service from '../service'
import ProductItem from './ProductItem.vue'
import { store } from '../main';

export default {
	components: {
    	'product-item': ProductItem,
  	},
	data() {
		return {
			error: "",
			searchString: "",
			products: [],
			timer: null
		}
	},
	watch: {
		searchString: function(str) {
			// Start search, when user end typing
			this.startTimer();
		}
	},
	methods: {
		startTimer: function() {
			// Delete running timer
			if (this.timer != null) {
				this.stopTimer();
			}

			// Start new timer
			this.timer = setInterval(this.startSearch, 1000);
		},
		stopTimer: function() {
			// Remove timer
			clearInterval(this.timer);
			this.timer = null;
		},
		startSearch: function() {
			this.stopTimer();
			var sessionToken = localStorage.getItem("sessionToken");

			if (sessionToken != undefined) {
				this.products = [];

				var self = this;
				service.search(this.searchString, sessionToken)
				.then((response) => {
					var items = [];

					if (response != undefined) {
						response.data.forEach(element => {
							var item = {
								id: element.id,
								productNo: element.productNo,
								name: element.name,
								description: element.description,
								image: element.image,
								price: element.price
							};
							items.push(item);
						});
					}
					else {
						console.log(self);
						self.error = "Keine Daten empfangen.";
					}

					this.products = items;
				}).catch ((e) => {
					// Token is expired => get new token with refresh-token and restart search
					if (e.response.data != undefined && e.response.data.error != undefined && e.response.data.error == "invalid_token") {
						service.refreshToken(this.tokenRefreshCallback);
					}
					// Other error
					else {
						self.error = "Der Service ist nicht erreichbar."
					}
				});
			}
			else {
				// Session erneuern
				this.error = "Kein Session-Token gefunden, bitte loggen Sie sich erneut ein.";
			}
		},
		tokenRefreshCallback: function() {
			// Restart search with new token
			this.startSearch();
		}
	}
}
</script>