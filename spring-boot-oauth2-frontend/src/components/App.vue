<template>
	<div>
		<nav class="navbar navbar-default">
			<div class="container">
				<ul class="nav navbar-nav">
					<li><router-link to="/home" v-if="user.authenticated">HOME</router-link></li>
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

	export default {
		data() {
			return {
				user: auth.user
			}
		}
	}
</script>
