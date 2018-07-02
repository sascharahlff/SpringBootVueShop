<template></template>

<script>
import auth from '../auth'
import {router} from '../main'

export default {
	created: function() {
		// TODO auth.user.authenticated = false;
		router.push("/login");
	}
}
</script>