<template>
	<tr>
		<td>{{ this.cartItem.getItem().getProductNo() }}</td>
		<td>{{ this.cartItem.getItem().getName() }}</td>
		<td class="text-right">{{ this.cartItem.getItem().getPrice() }}</td>
		<td class="text-right">{{ this.cartItem.getQuantity() }}</td>
	</tr>
</template>

<script>
export default {
	props: ["cartItem"]
}
</script>