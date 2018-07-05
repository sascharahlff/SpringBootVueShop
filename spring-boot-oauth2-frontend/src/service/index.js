import axios from 'axios';

export default {
	login: async function(login, password) {
		var formData = new FormData();
		formData.append('username', login);
		formData.append('password', password);
		formData.append('grant_type', 'password');

		var json = await axios({
			method: "POST",
			baseURL: "http://localhost:8081/",
			url: "oauth/token",
			auth: {
				username: "itemis",
				password: "secret"
			},
			headers: {
				"Access-Control-Allow-Origin": "http://localhost:8080",
				"Content-type": "application/x-www-form-urlencoded; charset=utf-8"
			},
			data: formData
		});

		return json;
	},
	refreshToken: async function(callback) {
		var formData = new FormData();
		formData.append('refresh_token', localStorage.getItem("refreshToken"));
		formData.append('grant_type', 'refresh_token');

		var json = await axios({
			method: "POST",
			baseURL: "http://localhost:8081/",
			url: "oauth/token",
			auth: {
				username: "itemis",
				password: "secret"
			},
			headers: {
				"Access-Control-Allow-Origin": "http://localhost:8080",
				"Accept": "application/json",
			},
			data: formData
		}).then((response) => {
			if (response != undefined && response.data != undefined && response.data.access_token != undefined) {
				localStorage.setItem("sessionToken", response.data.access_token);
				localStorage.setItem("refreshToken", response.data.refresh_token);

				if (callback != undefined) {
					callback();
				}
			}
		});
	},
	search:  async function(search, token) {
		var formData = new FormData();
		formData.append('search', search);

		var json = await axios({
			method: "POST",
			baseURL: "http://localhost:8081/",
			url: "secured/products",
			headers: {
				"Access-Control-Allow-Origin": "http://localhost:8080",
				"Accept": "application/json",
				"Authorization": "Bearer" + token
			},
			data: formData
		});

		return json;
	},
	getAddressList:  async function(userId, token) {
		var formData = new FormData();
		formData.append('userid', userId);

		var json = await axios({
			method: "POST",
			baseURL: "http://localhost:8081/",
			url: "secured/address",
			headers: {
				"Access-Control-Allow-Origin": "http://localhost:8080",
				"Accept": "application/json",
				"Authorization": "Bearer" + token
			},
			data: formData
		});

		return json;
	}
}