import {router} from '../main'
import axios from 'axios';

export default {
	user: {
		authenticated: false
	},
	login: function(context) {
		var formData = new FormData();
		formData.append('username', 'foo');
		formData.append('password', 'password');
		formData.append('grant_type', 'password');

		axios({
			method: "POST",
			baseURL: "http://localhost:8081/",
			url: "oauth/token",
			auth: {
				username: "spring-security-oauth2-read-client",
				password: "foo"
			},
			headers: {
				"Access-Control-Allow-Origin": "http://localhost:8080",
				"Content-type": "application/x-www-form-urlencoded; charset=utf-8"
			},
			data: formData
		}).then ((response) => {
			if (response != undefined && response.data != undefined && response.data.access_token != undefined) {
				localStorage.setItem("sessionToken", response.data.access_token);
				this.user.authenticated = true;
				// TODO
				console.log("token: " + localStorage.getItem("sessionToken") +" | authenticated: "+ this.user.authenticated);
				router.push('/home');
			}
			else {
				// TODO Error message
			}
		}).catch ((error) => {
				// TODO Error message
		});
	}
}