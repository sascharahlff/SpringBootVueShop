<template>
<div class="container">
	<div style="float:right">
		<button type="button" class="btn btn-primary basket" v-on:click="showBasket()">
			Warenkorb <span class="badge badge-light">{{ basketItems.length }}</span>
		</button>
	</div>
	<div>
		<nav xclass="navbar navbar-expand-lg navbar-light bg-light">
			<router-link class="navbar-brand" to="/home" v-if="this.user.authenticated">HOME</router-link>
			<router-link class="navbar-brand" to="/products" v-if="this.user.authenticated">PRODUKTE</router-link>
			<router-link class="navbar-brand" to="/logout" v-if="this.user.authenticated">LOGOUT</router-link>
		</nav>
	</div>
	
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
				user: auth.user,
				basketItems: store.state.basketItems
			}
		},
		created: function() {
			auth.setDefaults();
		},
		methods: {
			showBasket: function() {
				router.push("/basket");
			}
		}
	}
</script>