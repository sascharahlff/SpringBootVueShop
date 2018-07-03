export default {
	user: {
		authenticated: false
	},
	setDefaults: function() {
		var state = sessionStorage.getItem("isLoggedIn");

		if (state === null) {
			alert("state is null");
			sessionStorage.setItem("isLoggedIn", false);
			this.user.authenticated = false;
		}
		else {
			alert("state is: "+ JSON.parse(state));
			this.user.authenticated = JSON.parse(state);
		}
	},
	setLoggedIn: function() {
		var currentState = this.user.authenticated;

		if (currentState) {
			this.user.authenticated = false;
			sessionStorage.setItem("isLoggedIn", false);
		}
		else {
			this.user.authenticated = true;
			sessionStorage.setItem("isLoggedIn", true);
		}
	},
	setNewLoggedIn: function(state) {
		console.log("current state: "+ state);
		if (state == null) {
			console.log("set false");
			this.user.authenticated = false;
		}
		else {
			console.log("set state: "+ state);
			this.user.authenticated = state;
		}
		
		sessionStorage.setItem("isLoggedIn", this.user.authenticated);
		alert("set user loggin by state: "+ this.user.authenticated +" - "+ sessionStorage.getItem("isLoggedIn"));		
	}
}