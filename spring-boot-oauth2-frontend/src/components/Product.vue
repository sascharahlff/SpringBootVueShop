<template>
	<div class="form-inline my-2 my-lg-0">
		<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" v-bind:value="searchString" v-on:input="searchString = $event.target.value">
	</div>
</template>

<script>
import auth from '../auth'
import services from '../services'

export default {
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
			this.timer = setInterval(this.startSearch, 3000);
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
						console.log(response);
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