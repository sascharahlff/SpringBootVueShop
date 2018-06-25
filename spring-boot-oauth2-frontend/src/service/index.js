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
	}
}