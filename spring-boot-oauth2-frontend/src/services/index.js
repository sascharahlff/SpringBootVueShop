import axios from 'axios';

export default {
	searchProducts: async function(search, token) {
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