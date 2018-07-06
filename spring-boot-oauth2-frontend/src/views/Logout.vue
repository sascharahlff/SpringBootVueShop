<template></template>

<script>
import auth from '../auth'
import router from '../router'

export default {
	created: function() {
		auth.setAuthenticated(false);
		router.push("/login");
	}
}
</script>