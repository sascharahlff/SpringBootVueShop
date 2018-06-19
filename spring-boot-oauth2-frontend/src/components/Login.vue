<template>
	<div class="col-sm-4 col-sm-offset-4">
		<h2>Log in</h2>
		<button class="btn btn-primary" @click="login()">Log in</button>
	</div>
</template>

<script>
import auth from '../auth'

export default {
	methods: {
		login: function() {
			auth.login(this);
		}
	}
}
</script>
