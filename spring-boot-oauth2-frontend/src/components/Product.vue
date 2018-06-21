<template>
	<div class="form-inline my-2 my-lg-0">
		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" v-bind:value="searchString" v-on:input="searchString = $event.target.value">
	
		<ul class="list-group mt-5">
			<!-- <li v-for="product in this.products" v-bind:key="product.id">{{ product.id }}</li> -->
			<!-- <product-item v-repeat="this.products" v-for="product in products" v-bind:key="product.id" v-bind:id="product.id" /> -->
			<!-- <product-item v-for="product in products" v-bind:key="product.id" v-bind:id="myId" /> -->
		</ul>
	</div>
</template>


<script>
import auth from '../auth'
import services from '../services'
import ProductItem from './ProductItem.vue'

export default {
	components: {
    	'product-item': ProductItem,
  	},
	data() {
		return {
			searchString: "",
			myId: 1,
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

				services.searchProducts(this.searchString, sessionToken)
				.then((response) => {
					var items = [];

					if (response != undefined) {
						response.data.forEach(element => {
							var item = {
								id: element.id,
								name: element.name
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