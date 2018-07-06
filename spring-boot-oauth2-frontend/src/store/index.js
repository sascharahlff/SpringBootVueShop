import Vue from 'vue'
import Vuex from 'vuex'
import CartItemVO from '../model/CartItemVO.js';
import ProductVO from '../model/ProductVO.js';

Vue.use(Vuex)

const store = new Vuex.Store({
	state: {
		cartItems: []
	},
	mutations: {
		init (stazr) {
			console.log("init");
			if (sessionStorage.getItem("cart")) {
				var sessionState = JSON.parse(sessionStorage.getItem("cart"));

				if (sessionState.cartItems != undefined) {
					sessionState.cartItems.forEach((cartItem) => {
						var obj = cartItem.item;
						var product = new ProductVO(obj.id, obj.productNo, obj.name, obj.description, obj.image, obj.price);
						var item = new CartItemVO(cartItem.id, product, cartItem.quantity);
						this.state.cartItems.push(item);
						console.log(this.cartItems);
					})

					this.commit("saveCartToSession");
				}
			}
		},
		addToCart (state, item) {
			state.cartItems.push(item);
			this.commit("saveCartToSession");
		},
		changeItem (state, item) {
			var products = state.cartItems;
			var exists = false;

			products.forEach(cartItem => {
				if (cartItem.item.getId() == item.id) {
					cartItem.addQuantity(1);
					exists = true;
					return true;
				}
			});

			if (!exists) {
				var newCartItem = new CartItemVO(item.getId(), item, 1);
				store.commit("addToCart", newCartItem);
			}

			this.commit("saveCartToSession");
		},
		clear (state) {
			while(state.cartItems.length > 0) {
				state.cartItems.pop();
			}
		},
		saveCartToSession (state) {
			sessionStorage.setItem("cart", JSON.stringify(state));
		}
	}
})

export default store;