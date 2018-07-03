import Vue from 'vue'
import Vuex from 'vuex'
import App from './views/App.vue'
import router from './router'

Vue.use(Vuex)

export const store = new Vuex.Store({
	state: {
		basketItems: []
	}
})

new Vue({
	el: '#app',
	router,
	store,
	template: '<App/>',
	components: { App }
})