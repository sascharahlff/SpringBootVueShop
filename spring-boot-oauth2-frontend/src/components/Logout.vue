<template></template>

<script>
import auth from '../auth'
import {router} from '../main'

export default {
	created: function() {
		//auth.setLogInState(false);
		router.push("/login");
	}
}
</script>