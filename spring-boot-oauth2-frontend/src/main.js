import Vue from 'vue'
import App from './components/App.vue'
import Home from './components/Home.vue'
import Product from './components/Product.vue'
import Login from './components/Login.vue'
import Logout from './components/Logout.vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'

Vue.use(VueResource)
Vue.use(VueRouter)

const routes = [
	{ path: '/home', component: Home },
	{ path: '/products', component: Product },
	{ path: '/login', component: Login },
	{ path: '/logout', component: Logout }
]

export const router = new VueRouter({
	routes
})

new Vue({
	el: '#app',
	router,
	template: '<App/>',
	components: { App }
})
