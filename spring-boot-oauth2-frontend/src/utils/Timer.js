export default class Timer {
	constructor(interval, callback) {
		this.interval = interval;
		this.running = false;
		this.callback = callback;
	}

	start() {
		if (this.running) {
			clearInterval(this.timerId);
			this.running = false;
		}

		this.running = true;
		self = this;
		self.timerId = setInterval(function() {
			self.tick(); 
		}, self.interval);
	}

	tick() {
		this.stop();
		// TODO dispatch Event
		if (this.callback != null) {
			this.callback();
		}
	}

	stop() {
		clearInterval(this.timerId);
		this.running = false;
	}
}