<template>
	<div class="container">
		<div v-if="error !== ''" class="alert alert-danger" role="alert">{{ error }}</div>
		<div v-if="info !== ''" class="alert alert-success" role="alert">{{ info }}</div>
		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" v-bind:value="searchString" v-on:input="searchString = $event.target.value">
	
		<ul class="list-group mt-5" style="clear:right">
			<product-item v-for="product in this.products" v-bind:key="product.getId()" v-bind:product="product" v-on:addItem="addProduct()"></product-item>
		</ul>
	</div>
</template>

<script>
import Vue from 'vue'
import ProductItem from './ProductItem.vue'
import ProductVO from '../model/ProductVO.js';
import service from '../service'
import Timer from '../utils/Timer.js';

export default {
	components: {
    	'product-item': ProductItem,
  	},
	data() {
		return {
			error: "",
			info: "",
			searchString: "",
			products: [],
			searchTimer: null,
			removeTimer: null
		}
	},
	watch: {
		searchString: function(str) {
			// Start search, when user ends typing
			this.startTimer();
		}
	},
	methods: {
		startTimer: function() {
			if (this.searchTimer == null) {
				this.searchTimer = new Timer(1000, this.startSearch);
			}
			else {
				this.searchTimer.stop();
			}

			this.searchTimer.start();
		},
		startSearch: function() {
			this.searchTimer.stop();
			var sessionToken = localStorage.getItem("sessionToken");

			if (sessionToken != undefined) {
				this.products = [];
				var self = this;

				service.search(this.searchString, sessionToken)
				.then((response) => {
					var items = [];

					if (response != undefined) {
						response.data.forEach(element => {
							var productVo = new ProductVO(element.id, element.productVo, element.name, element.description, element.image, element.price);
							items.push(productVo);
						});
					}
					else {
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
		},
		addProduct: function() {
			this.info = "Das Produkt wurde in den Warenkorb gelegt.";
			var self = this;
			this.clearInfo();
		},
		clearInfo: function() {
			if (this.removeTimer == null) {1
				this.removeTimer = new Timer(2000, this.clearInfoHandler);
			}

			this.removeTimer.start();
		},
		clearInfoHandler: function() {
			this.info = "";
		}
	}
}
</script>