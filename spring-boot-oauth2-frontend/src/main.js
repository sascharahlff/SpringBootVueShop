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

	beforeCreate() {
		store.commit('init');
	}
})