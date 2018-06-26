<template>
<div class="container">
	<div class="row">
		<div class="col-md-8">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<router-link class="navbar-brand" to="/home" v-if="user.authenticated">HOME</router-link>
				<router-link class="navbar-brand" to="/products" v-if="user.authenticated">PRODUKTE</router-link>
				<router-link class="navbar-brand" to="/logout" v-if="user.authenticated">LOGOUT</router-link>
			</nav>
		</div>  

		<div class="col-md-4 text-right" v-if="user.authenticated">
			<button type="button" class="btn btn-primary basket" v-on:click="showBasket()">
				Warenkorb <span class="badge badge-light">{{ basketItems.length }}</span>
			</button>
		</div>
	</div>
	
	<div class="row">
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
				user: auth.user,
				basketItems: store.state.basketItems
			}
		},
		created: function() {
			// Delete session token on start 
			localStorage.removeItem("sessionToken");
			// Open Login template
			router.push("/login");
		},
		methods: {
			showBasket: function() {
				router.push("/basket");
			}
		}
	}
</script>