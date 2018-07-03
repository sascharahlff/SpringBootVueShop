<template>
<div class="container" style="clear:both">
	<div class="row">
		<div class="col-sm-2">{{ this.basketItem.getItem().getName() }}</div>
		<div class="col-sm-2">{{ this.basketItem.getQuantity() }}</div>
		<div class="col-sm-2">{{ this.basketItem.getItem().getPrice() }}</div>
	</div>
</div>
</template>

<script>

export default {
	props: ["basketItem"],
	methods: {
	}
}
</script>