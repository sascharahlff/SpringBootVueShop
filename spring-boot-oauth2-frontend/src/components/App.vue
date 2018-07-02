<template>
<div class="container">
	<button type="button" class="btn btn-primary basket" v-on:click="showBasket()">
		Warenkorb <span class="badge badge-light">{{ basketItems.length }}</span>
	</button>
	<!--
	<div>
		<div style="float:right">
			<button type="button" class="btn btn-primary basket" v-on:click="showBasket()">
				Warenkorb <span class="badge badge-light">{{ basketItems.length }}</span>
			</button>
		</div>
		<div>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<router-link class="navbar-brand" to="/home" v-if="this.authenticated">HOME</router-link>
				<router-link class="navbar-brand" to="/products" v-if="this.authenticated">PRODUKTE</router-link>
				<router-link class="navbar-brand" to="/logout" v-if="this.authenticated">LOGOUT</router-link>
			</nav>
		</div>
	</div>-->
	
	<div style="clear:right">
		<router-view></router-view>
	</div>
</div>
</template>

<script>
	import auth from '../auth'
	import { router } from '../main';
	import { store } from '../main';

	export default {
		data() {
			return {
				//authenticated: store.state.authenticated,
				basketItems: store.state.basketItems
			}
		},
		created: function() {
			// var isLoggedIn = false;//auth.isLoggedIn();

			// console.log("isLoggedIn: " + isLoggedIn);

			// if (!isLoggedIn) {
			// 	console.log("need to login");
			// 	router.push("/login");
			// }
		},
		methods: {
			showBasket: function() {
				alert("test");
				console.log("test");
				this.authenticated = true;
				// TODO router.push("/basket");
			}
		}
	}
</script>