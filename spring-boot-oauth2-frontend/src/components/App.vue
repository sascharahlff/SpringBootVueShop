<template>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<router-link class="navbar-brand" to="/home" v-if="user.authenticated">HOME</router-link>
			<router-link class="navbar-brand" to="/products" v-if="user.authenticated">PRODUKTE</router-link>
			<router-link class="navbar-brand" to="/logout" v-if="user.authenticated">LOGOUT</router-link>
		</nav>
		<div class="container">
			<router-view></router-view>
		</div>
	</div>
</template>

<script>
	import auth from '../auth'
	import { router } from '../main';

	export default {
		data() {
			return {
				user: auth.user
			}
		},
		created: function() {
			// Delete session token on start 
			localStorage.removeItem("sessionToken");
			localStorage.removeItem("basketItems");
			// Open Login template
			router.push("/login");
		}
	}
</script>