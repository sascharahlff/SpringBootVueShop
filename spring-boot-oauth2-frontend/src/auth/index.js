import axios from 'axios';

export default {
	user: {
		authenticated: false
	},
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
	}
}