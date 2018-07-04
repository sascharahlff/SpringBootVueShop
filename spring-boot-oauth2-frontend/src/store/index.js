import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
	state: {
		cartItems: []
	},
	mutations: {
		addToCart (state, item) {
			state.cartItems.push(item);
		},
		clear (state) {
			while(state.cartItems.length > 0) {
				state.cartItems.pop();
			}
		}
	}
})