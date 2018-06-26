<template>
	<div class="row basketItem">
		<div class="col-md-2"><img class="img-fluid" width="100" v-bind:src="'src/assets/images/'+ product.image" v-bind:title="product.name"></div>
		<div class="col-md-6">
			<div class="card-body">
				<h5 class="card-title">{{ product.getName() }} ({{ product.getProductNo()}})</h5>
				<p class="card-text">{{product.getDescription()}}</p>
				<p class="card-text">{{product.getPrice()}}</p>
				<a href="#" class="btn btn-primary" v-on:click="submit(product)">In den Warenkorb</a>
			</div>
		</div>
	</div>
</template>

<script>
import { store } from '../main';
import ProductVO from '../model/ProductVO.js';
import BasketItemVO from '../model/BasketItemVO.js';

export default {
	props: ["product"],
	methods: {
		submit: function(item) {
			var products = store.state.basketItems;
			var exists = false;

			products.forEach(basketItem => {
				if (basketItem.item.id == item.id) {
					basketItem.addQuantity(1);
					exists = true;
					return
				}
			});

			if (!exists) {
				var basketItem = new BasketItemVO(item.getId(), item, 1);
				store.state.basketItems.push(basketItem);
			}

			this.$emit('addItem');
		}
	}
}
</script>