<template>
	<div>
		<nav class="navbar navbar-default">
			<div class="container">
				<ul class="nav navbar-nav">
					<li><router-link to="/home" v-if="user.authenticated">HOME</router-link></li>
					<li><router-link to="/products" v-if="user.authenticated">PRODUKTE</router-link></li>
					<li><router-link to="/logout" v-if="user.authenticated">LOGOUT</router-link></li>
					<li><router-link to="/login" v-if="!user.authenticated">LOGIN</router-link></li>
				</ul>
			</div>
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
			// Open Login template
			router.push("/login");
		}
	}
</script>