<template>
<div class="container" style="clear:both">
	<div class="row">
		<div class="col-sm-2">{{ this.cartItem.getItem().getName() }}</div>
		<div class="col-sm-2">{{ this.cartItem.getQuantity() }}</div>
		<div class="col-sm-2">{{ this.cartItem.getItem().getPrice() }}</div>
	</div>
</div>
</template>

<script>
export default {
	props: ["cartItem"]
}
</script>