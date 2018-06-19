package de.itemis.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DomainController {
	private static final String ROOT_URL = "/";
	private static final String USER_URL = "/users";

	@GetMapping(ROOT_URL)
	public String getIndex() {
		return "index";
	}

	@GetMapping(USER_URL)
	public String getUsers() {
		return "user";
	}

	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return "Hello World!";
	}
}
