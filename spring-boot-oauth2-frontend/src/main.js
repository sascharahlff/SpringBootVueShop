import Vue from 'vue'
import App from './views/App.vue'
import router from './router'
import store from './store'

new Vue({
	el: '#app',
	router,
	store,
	template: '<App/>',
	components: { App },

	// Get cart items from session storage
	beforeCreate() {
		store.commit('init');
	}
})