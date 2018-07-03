import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Product from '../views/Product.vue'
import Basket from '../views/Basket.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import auth from '../auth'

Vue.use(VueRouter)

// Protect all secured views => redirect to login
const checkAuthentication = (to, from, next) => {
	if (!auth.isAuthenticated()) {
		console.log("main.js routing to login");
		router.push("/login");
		return
	}
	
	next();
}

const router = new VueRouter({
	routes: [
		{
			path: "/home",
			name: "Home",
			component: Home,
			beforeEnter: checkAuthentication
		},
		{
			path: "/products",
			name: "Products",
			component: Product,
			beforeEnter: checkAuthentication
		},
		{
			path: "/basket",
			name: "Basket",
			component: Basket,
			beforeEnter: checkAuthentication
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

export default router
