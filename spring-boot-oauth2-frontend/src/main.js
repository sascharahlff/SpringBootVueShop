import auth from './auth'
import Vue from 'vue'
import Vuex from 'vuex'
import App from './components/App.vue'
import Home from './components/Home.vue'
import Product from './components/Product.vue'
import Login from './components/Login.vue'
import Logout from './components/Logout.vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'

Vue.use(Vuex)
Vue.use(VueResource)
Vue.use(VueRouter)

// Protect all secured views => redirect to login
const ifAuthenticated = (to, from, next) => {
	if (!auth.user.authenticated) {
		router.push("/login");
		return
	}

	next();
}

export const store = new Vuex.Store({
	state: {
		test: "Hello World!",
		basketItems: []
	},
	mutations: {
		addItem(product) {
			basketItems.push(product);
		}
	}
})

export const router = new VueRouter({
	routes: [
		{
			path: "/home",
			name: "Home",
			component: Home,
			beforeEnter: ifAuthenticated
		},
		{
			path: "/products",
			name: "Products",
			component: Product,
			beforeEnter: ifAuthenticated
		},
		{
			path: "/login",
			component: Login
		},
		{
			path: "/logout",
			component: Logout
		}
	]
})

new Vue({
	el: '#app',
	router,
	store,
	template: '<App/>',
	components: { App }
})
