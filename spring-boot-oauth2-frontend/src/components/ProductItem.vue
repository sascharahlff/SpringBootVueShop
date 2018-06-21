<template>
	<!-- <div class="card">
		<div class="container-fluid">
			<div class="card-body">
				<h5 class="card-title">{{ product.name }} ({{ product.productNo}})</h5>
				<p class="card-text">{{product.description}}</p>
				<p class="card-text">{{product.price}}</p>
				<a href="#" class="btn btn-primary">In den Warenkorb</a>
			</div>
			<div>
				<img class="img-fluid" width="100" v-bind:src="'src/assets/images/'+ product.image" v-bind:title="product.name">
			</div>
		</div>
	</div> -->

	<div class="row pt-5">
		<div class="col-md-2"><img class="img-fluid" width="100" v-bind:src="'src/assets/images/'+ product.image" v-bind:title="product.name"></div>
		<div class="col-md-10">
			<div class="card-body">
				<h5 class="card-title">{{ product.name }} ({{ product.productNo}})</h5>
				<p class="card-text">{{product.description}}</p>
				<p class="card-text">{{product.price}}</p>
				<a href="#" class="btn btn-primary">In den Warenkorb</a>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	props: ["product"]
}
</script>