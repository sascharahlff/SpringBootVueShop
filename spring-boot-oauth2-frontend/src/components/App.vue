<template>
<div class="container">
	<div>
		<div style="float:right">
			{{ this.authenticated }}

			<button type="button" class="btn btn-primary basket" v-on:click="showBasket()">
				Warenkorb <span class="badge badge-light">{{ basketItems.length }}</span>
			</button>
		</div>
		<div>
			<nav xclass="navbar navbar-expand-lg navbar-light bg-light">
				<router-link class="navbar-brand" to="/home" v-if="this.authenticated">HOME</router-link>
				<router-link class="navbar-brand" to="/products" v-if="this.authenticated">PRODUKTE</router-link>
				<router-link class="navbar-brand" to="/logout" v-if="this.authenticated">LOGOUT</router-link>

				<!--
				<router-link class="navbar-brand" to="/home" v-if="user.authenticated">HOME</router-link>
				<router-link class="navbar-brand" to="/products" v-if="user.authenticated">PRODUKTE</router-link>
				<router-link class="navbar-brand" to="/logout" v-if="user.authenticated">LOGOUT</router-link>
				-->
			</nav>
		</div>
	</div>
	
	<div style="clear:right">
		<router-view></router-view>
	</div>
</div>
</template>

<script>
	// TODO import auth from '../auth'
	import { router } from '../main';
	import { store } from '../main';

	export default {
		data() {
			return {
				//user: auth.user,
				authenticated: store.state.authenticated,
				basketItems: store.state.basketItems
			}
		},
		created: function() {
			// Delete session token on start 
			localStorage.removeItem("sessionToken");
			// Open Login template
			console.log("auth: " + this.authenticated);
			if (!this.authenticated) {
				console.log("router: login");
				router.push("/login");
			}
		},
		methods: {
			showBasket: function() {
				console.log("basket: " + this.authenticated);
				router.push("/basket");
			}
		}
	}
</script>