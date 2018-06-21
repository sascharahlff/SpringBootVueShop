<template>
	<div class="form-inline my-2 my-lg-0">
		<!--<form class="form-inline my-2 my-lg-0">-->
			<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" v-bind:value="searchString" v-on:input="searchString = $event.target.value">
			<!-- <input class="form-control mr-sm-2" v-model.lazy="searchString" v-on:keydown="search" type="search" placeholder="Search" aria-label="Search"> -->
			<!-- <button class="btn btn-outline-success my-2 my-sm-0" type="submit" v-on:click="search">Search</button> -->
			<button v-on:click="bla">click me</button>
			<button v-on:click="reset">reset</button>
		<!--</form>-->
	</div>
</template>

<script>
import auth from '../auth'

export default {
	data() {
		return {
			searchString: "",
			timer: null
		}
	},
	watch: {
		searchString: function(str) {
		}		
	},
	methods: {
		startTimer: function() {
			// Delete running Timer
			if (this.timer != null) {
				this.stopTimer();
			}

			console.log("timer: create new timer");
			this.timer = setInterval(this.reset, 3000);
		},
		stopTimer: function() {
			console.log("timer: destroy old timer");
			clearInterval(this.timer);
			this.timer = null;
		},
		timeOut: function() {
			console.log("timer: start search");
			this.reset();
		},
		bla: function() {
			if (this.timer != null) {
				clearInterval(this.timer);
				this.timer = null;
			}

			this.startTimer();

			// this.timer.setInterval(this.timerFunction(), 3000);
		},
		reset: function() {
			console.log("start search");
			this.stopTimer();
		}
		// timerFunction: function() {
		// 	clearInterval(this.timer)
		// 	console.log("stop timer");
		// }
	}
	// ,
	// methods: {
	// 	search: function() {
	// 		console.log(this.searchString);


	// 	}
	// }
}
</script>