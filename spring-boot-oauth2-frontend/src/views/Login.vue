<template>
	<div class="container">
		<div v-if="error != ''" class="alert alert-danger" role="alert">{{ error }}</div>
		<div class="form-group">
			<label class="bold" for="userLogin">Login</label>
			<input class="form-control" id="userLogin" v-model="user" placeholder="Your login name">
		</div>
		<div class="form-group">
			<label class="bold" for="userPassword">Password</label>
			<input class="form-control" id="userPassword" type="password" v-model="password" placeholder="Your password">
		</div>
		<button class="btn btn-primary" v-on:click="login">Login</button>
	</div>
</template>

<script>
import auth from '../auth'
import router from '../router'
import service from '../service'

export default {
	data() {
		return {
			user: "foo",
			password: "bar",
			error: ""
		}
	},
	created: function() {
		// Remove session when login is called
		if (auth.isAuthenticated()) {
			auth.setAuthenticated(false);
		}
	},
	methods: {
		login: function() {
			var self = this;
			// Async call
			service.login(this.user, this.password)
			.then((response) => {
				if (response != undefined && response.data != undefined && response.data.access_token != undefined) {
					localStorage.setItem("sessionToken", response.data.access_token);
					localStorage.setItem("refreshToken", response.data.refresh_token);
					sessionStorage.setItem("userId", response.data.user_id);
					auth.setAuthenticated(true);
					this.error = "";
					router.push("/home")
				}
				else {
					self.showError();
				}
			}).catch ((e) => {
				self.showError();
			});
		},
		showError: function() {
			this.error = "Beim Login ist ein Fehler aufgetreten, bitte korrigieren Sie Ihre Anmeldedaten.";
			auth.setAuthenticated(false);
		}
	}
}
</script>