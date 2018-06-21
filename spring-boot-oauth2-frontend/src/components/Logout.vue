<template>
</template>

<script>
import auth from '../auth'
import {router} from '../main'

export default {
	created: function() {
		auth.user.authenticated = false;
		localStorage.removeItem("basketItems");
		router.push("/login");
	}
}
</script>