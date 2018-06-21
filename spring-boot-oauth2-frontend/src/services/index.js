import axios from 'axios';

export default {
	searchProducts: async function(search, token) {
		var json = await axios({
			method: "GET",
			baseURL: "http://localhost:8081/",
			url: "secured/products",
			headers: {
				"Access-Control-Allow-Origin": "http://localhost:8080",
				"Accept": "application/json",
				"Authorization": "Bearer" + token
			}
		});

		return json;
	}
}