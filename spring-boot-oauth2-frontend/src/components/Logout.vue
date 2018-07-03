<template></template>

<script>
import auth from '../auth'
import {router} from '../main'

export default {
	created: function() {
		sessionStorage.setItem("isLoggedIn", false);
		auth.setDefaults();
		router.push("/login");
	}
}
</script>