<template>
	<div class="container">
		<basket-item v-for="item in this.basketItems" v-bind:key="item.getId()" v-bind:basketItem="item"></basket-item>
	</div>
</template>

<script>

import { store } from '../main';
import BasketItem from './BasketItem.vue'

export default {
	components: {
		'basket-item': BasketItem,
	},
	data() {
		return {
			basketItems: []
		}
	},
	created: function() {
		if (store != undefined && store.state != undefined && store.state.basketItems != undefined) {
			this.basketItems = store.state.basketItems;
		}
	}
}
</script>