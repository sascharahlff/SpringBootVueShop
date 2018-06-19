// TODO import {router} from '../main'

import axios from 'axios';

export default {
	user: {
		authenticated: false
	},
	login: function(context) {
		var formData = new FormData();
		//formData.append('client_id', 'spring-security-oauth2-read-client');
		//formData.append('client_secret', 'foo');
		formData.append('username', 'foo');
		formData.append('password', 'password');
		formData.append('grant_type', 'password');

		axios({
			method:'POST',
			baseURL: `http://localhost:8081/`,
			url: 'oauth/token',
			auth: { username:'spring-security-oauth2-read-client', password:'foo' },
			headers: { 'Access-Control-Allow-Origin': 'http://localhost:8080',
			  "Content-type": "application/x-www-form-urlencoded; charset=utf-8"},
			data: formData
		  }).then ((response) => {
			console.log(response)
		  }).catch ((error) => {
			alert("error")
		});

		//context.$http({url: 'http://localhost:8081/oauth/token', formData, method: 'POST', 
		/*
		context.$http.post('http://localhost:8081/oauth/token', formData, {
			headers: {
				'content-type': 'application/json',
				'Access-Control-Allow-Origin': '*'
			}
		})
		.then((response) => {
			alert("response");
		}, err => {
			alert("error");
		});
		*/
		/*
				localStorage.setItem('authorization', JSON.stringify(response.body.access_token));

				// ir para a home do sistema
				//location.href = '/index';
				this.$router.push({name: 'index'});
			}, err => {
				console.log("erro ao realizar o login");
			}
		);
		*/
	}

	/*
	login(context, credentials, redirect) {
		context.$http.post(LOGIN_URL, creds, (data) => {
			localStorage.setItem('id_token', data.id_token)
			localStorage.setItem('access_token', data.access_token)

			this.user.authenticated = true

			// Redirect to a specified route
			if(redirect) {
				router.go(redirect)        
			}
		}).error((err) => {
			context.error = err
		})
	}
	*/
}