<template>
	<div class="container">
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
import { store } from '../main';
import ProductItem from './ProductItem.vue'

export default {
	components: {
    	'product-item': ProductItem,
  	},
	data() {
		return {
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
						console.log("error");
					}

					this.products = items;
				}).catch ((e) => {
					console.log("exception: " + e);
				});
			}
		}
	}
}
</script>