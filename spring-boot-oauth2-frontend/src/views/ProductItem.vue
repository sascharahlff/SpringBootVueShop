<template>
	<div class="row cartItem">
		<div class="col-md-2"><img class="img-fluid" width="100" v-bind:src="'src/assets/images/'+ product.image" v-bind:title="product.name"></div>
		<div class="col-md-6">
			<div class="card-body">
				<h5 class="card-title">{{ product.getName() }} ({{ product.getProductNo()}})</h5>
				<p class="card-text">{{product.getDescription()}}</p>
				<p class="card-text">{{product.getPrice()}}</p>
				<button class="btn btn-primary" v-on:click="submit(product)">In den Warenkorb</button>
			</div>
		</div>
	</div>
</template>

<script>
import store from '../store';

export default {
	props: ["product"],
	methods: {
		submit: function(item) {
			store.commit("changeItem", item);

			// Send event to parent
			this.$emit('addItem');
		}
	}
}
</script>