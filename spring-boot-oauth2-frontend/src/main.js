import Vue from 'vue'
import Vuex from 'vuex'
//import VueSession from 'vue-session'
import VueRouter from 'vue-router'
import App from './components/App.vue'
import Home from './components/Home.vue'
import Product from './components/Product.vue'
import Basket from './components/Basket.vue'
import Login from './components/Login.vue'
import Logout from './components/Logout.vue'

//import auth from './auth'
//import VueResource from 'vue-resource'
//Vue.use(VueResource)


Vue.use(Vuex)
Vue.use(VueRouter)
//Vue.use(VueSession)

// Protect all secured views => redirect to login
const ifAuthenticated = (to, from, next) => {
	// console.log("main 1: => authenticated "+ auth.isAuthenticated());
	// if (auth.isAuthenticated() == false) {
	// 	console.log("main 2: => login.vue");
	// 	router.push("/login");
	// 	return
	// }
	var isLoggedIn = true;//auth.isLoggedIn();
	//var isLoggedIn = sessionStorage.getItem("authenticated");
	console.log("main: " + isLoggedIn);
	
	
	if (!isLoggedIn) {
		console.log("redirect to login");
		router.push("/login");
		return
	}
	
	next();
}

export default {
	// data() {
	// 	return {
	// 	}
	// },
	// methods: {
	// 	created: function() {
	// 		console.log("main created");
	// 	}
	// }
	// ,
	// methods: {
	// 	isAuth: () => {
	// 		sessionStorage.h
	// 		this.$session.has("authenticated");
	// 	}
	// }
}

export const store = new Vuex.Store({
	state: {
		basketItems: [],
		authenticated: false
	},
	mutations: {
		login(state) {
			state.authenticated = true;
			console.log("store state: " + localStorage.getItem("authenticated"))
		},
		logout(state) {
			state.authenticated = false;
			console.log(localStorage.getItem("authenticated"))
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
			path: "/basket",
			name: "Basket",
			component: Basket,
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