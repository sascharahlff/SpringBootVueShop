<template>
	<div class="container">
		<cart-item v-for="item in this.cartItems" v-bind:key="item.getId()" v-bind:cartItem="item"></cart-item>
		<button class="btn btn-primary" v-if="this.cartItems.length>0" v-on:click="showOrderOverview">Zur Kasse</button>
	</div>
</template>

<script>
import CartItem from './CartItem.vue'
import store from '../store';
import router from '../router';

export default {
	data() {
		return {
			cartItems: []
		}
	},
	created: function() {
		if (store != undefined && store.state != undefined && store.state.cartItems != undefined) {
			this.cartItems = store.state.cartItems;
		}
	},
	components: {
		'cart-item': CartItem,
	},
	methods: {
		showOrderOverview: function() {
			router.push("/order")
		}
	}
}
</script>