<template>
	<div class="container">
		<div class="form-group">
			<label for="exampleFormControlSelect1">Example select</label>
			<select class="form-control" id="exampleFormControlSelect1">
				<option v-for="address in this.addresses" v-bind:key="address.id">{{ address }}</option>
			</select>
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			addressList: []
		}
	},
	created: function() {
		// Load user addresses only once
		if (addressList.length == 0) {
			var sessionToken = localStorage.getItem("sessionToken");

			if (sessionToken != undefined) {
				var self = this;

				
			}

		}
	}
}
</script>