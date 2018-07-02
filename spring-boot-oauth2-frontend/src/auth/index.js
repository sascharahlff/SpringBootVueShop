export default {
	user: {
		authenticated: false
	}
	/*,
	isLoggedIn: function() {
		if (sessionStorage.getItem("isLoggedIn") != null) {
			//this.user.authenticated = true;
			return true;
		}
		//this.user.authenticated = false;
		return false;
	},
	setLogInState: function(state) {
		//this.user.authenticated = state;

		if (state) {
			sessionStorage.setItem("isLoggedIn", true);
		}
		else {
			sessionStorage.removeItem("isLoggedIn");
		}
	}
	*/
}