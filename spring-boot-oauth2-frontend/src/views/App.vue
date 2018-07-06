<template>
<div class="container">
	<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<router-link class="navbar-brand" to="/home" v-if="this.user.authenticated">HOME</router-link>
			<router-link class="navbar-brand" to="/products" v-if="this.user.authenticated">PRODUKTE</router-link>
			<router-link class="navbar-brand" to="/logout" v-if="this.user.authenticated">LOGOUT</router-link>
			<ul class="nav navbar-nav navbar-right" v-if="this.user.authenticated">
				<button type="button" class="btn btn-primary cart" v-on:click="showCart()">
					Warenkorb <span class="badge badge-light">{{ cartItems.length }}</span>
				</button>
			</ul>
		</nav>
	</div>
	<div style="clear:right">
		<router-view></router-view>
	</div>
</div>
</template>

<script>
	import auth from '../auth'
	import router from '../router';
	import store from '../store';

	export default {
		data() {
			return {
				user: auth.user,
				cartItems: store.state.cartItems
			}
		},
		created: function() {
			if (!auth.isAuthenticated()) {
				router.push("/login");
			}
		},
		methods: {
			showCart: function() {
				router.push("/cart");
			}
		}
	}
</script>