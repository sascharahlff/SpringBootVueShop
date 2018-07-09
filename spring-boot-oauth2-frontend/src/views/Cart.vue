<template>
	<div class="container">
		<table class="table">
			<thead>
			<tr>
				<th scope="col">Nr.</th>
				<th scope="col">Produkt</th>
				<th class="text-right" scope="col">Preis</th>
				<th class="text-right" scope="col">Menge</th>
			</tr>
			</thead>
			<tbody>
				<cart-item v-for="item in this.cartItems" v-bind:key="item.getId()" v-bind:cartItem="item"></cart-item>
			</tbody>
		</table>

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
			cartItems: store.state.cartItems
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