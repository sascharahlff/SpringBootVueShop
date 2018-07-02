<template>
	<div class="container">
		<div v-if="error != ''" class="alert alert-danger" role="alert">{{ error }}</div>
		<div class="form-group">
			<label for="userLogin">Login</label>
			<input class="form-control" id="userLogin" v-model="user" placeholder="Your login name">
		</div>
		<div class="form-group">
			<label for="userPassword">Password</label>
			<input class="form-control" id="userPassword" type="password" v-model="password" placeholder="Your password">
		</div>
		<button class="btn btn-primary" v-on:click="login">login</button>
	</div>
</template>

<script>
import auth from '../auth'
import service from '../service'
import {router} from '../main'
import { store } from '../main';

export default {
	data() {
		return {
			user: "foo",
			password: "bar",
			error: ""
		}
	},
	methods: {
		login: function() {
			console.log("login");
		},
		xlogin: function() {
			// Async call
			service.login(this.user, this.password)
			.then((response) => {
				if (response != undefined && response.data != undefined && response.data.access_token != undefined) {
					localStorage.setItem("sessionToken", response.data.access_token);
					localStorage.setItem("refreshToken", response.data.refresh_token);
					//auth.setLogInState(true);
					store.commit("login", true);

					console.log("login: " + store.state.authenticated);

					this.error = "";
					router.push("/home")
				}
				else {
					this.error = "Die Anmeldedaten waren fehlerhaft.";
					//auth.setLogInState(false);
				}
			}).catch ((e) => {
				console.log("error: " + e);
				this.error = "Beim Login ist ein interner Fehler aufgetreten.";
				//auth.setLogInState(false);
			});
		}
	}
}
</script>
