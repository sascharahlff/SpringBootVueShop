<template>
	<div class="row pt-5">
		<div class="col-md-2"><img class="img-fluid" width="100" v-bind:src="'src/assets/images/'+ product.image" v-bind:title="product.name"></div>
		<div class="col-md-6">
			<div class="card-body">
				<h5 class="card-title">{{ product.name }} ({{ product.productNo}})</h5>
				<p class="card-text">{{product.description}}</p>
				<p class="card-text">{{product.price}}</p>
				<a href="#" class="btn btn-primary" v-on:click="submit(product)">In den Warenkorb</a>
			</div>
		</div>
	</div>
</template>

<script>
import { store } from '../main';

export default {
	props: ["product"],
	methods: {
		submit: function(item) {
			store.state.basketItems.push(item);
		}
	}
}
</script>