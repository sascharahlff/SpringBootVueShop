import store from '../store';

export default {
	user: {
		authenticated: false
	},
	isAuthenticated: function() {
		var state = sessionStorage.getItem("authenticated");
		
		if (state === null) {
			return false;
		}
		
		this.user.authenticated = JSON.parse(state);
		return JSON.parse(state);
	},
	setAuthenticated: function(state) {
		sessionStorage.setItem("authenticated", state);
		this.user.authenticated = state;

		if (!state) {
			store.commit("clear");
		}
	}
}