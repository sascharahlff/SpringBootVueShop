<template>
	<div class="container">
		<div class="form-group">
			<label for="exampleFormControlSelect1">Example select</label>
			<select class="form-control" id="exampleFormControlSelect1">
				<option v-for="address in this.addressList" v-bind:key="address.id">{{ address.getName() }}</option>
			</select>
		</div>
	</div>
</template>

<script>
import service from '../service'
import AddressVO from '../model/AddressVO.js';

export default {
	data() {
		return {
			addressList: []
		}
	},
	created: function() {
		// Load user addresses only once
		if (this.addressList.length == 0) {
			var sessionToken = localStorage.getItem("sessionToken");

			if (sessionToken != undefined) {
				var self = this;
				service.getAddressList(1, sessionToken)
				.then((response) => {
					var items = [];

					if (response != undefined) {
						response.data.forEach(element => {
							var addressVO = new AddressVO(element.id, element.name, element.street, element.zipCode, element.city, element.preferredAddress);
							items.push(addressVO);
						});
					}
					else {
						self.error = "Keine Daten empfangen.";
					}

					this.addressList = items;
				});
			}
		}
	}
}
</script>