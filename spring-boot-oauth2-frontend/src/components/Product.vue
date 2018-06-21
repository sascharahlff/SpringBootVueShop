<template>
	<div class="form-inline my-2 my-lg-0">
		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" v-bind:value="searchString" v-on:input="searchString = $event.target.value">

		<product-item></product-item>

		<ul class="list-group mt-5">
			
			<li class="list-group-item mt-5">
				<div class="foo">
				Cras justo odio<br>
				bla,<br>
				Price
				</div>
			</li>
		</ul>
	</div>
</template>


<script>
import auth from '../auth'
import services from '../services'
import ProductItem from './ProductItem.vue'
// import Vue from 'vue'

// Vue.component('button-counter', {
// 	template: '<h1>Compoonent</h1>'
// })

export default {
	// install(Vue, options) {
	//  	Vue.component('product-item', ProductItem)
	// },
	components: {
    	'product-item': ProductItem,
  	},
	data() {
		return {
			searchString: "",
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
				services.searchProducts(this.searchString, sessionToken)
				.then((response) => {
					if (response != undefined) {
						response.data.forEach(element => {
							console.log(element.id);
						});
					}
					else {
						console.log("error");
					}
				}).catch ((e) => {
					console.log("exception");
				});
			}
		}
	}
}
</script>