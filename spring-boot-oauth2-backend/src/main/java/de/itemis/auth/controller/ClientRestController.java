package de.itemis.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.itemis.auth.domain.Client;
import de.itemis.auth.repository.ClientRepository;

@RestController
@RequestMapping("/secured")
public class ClientRestController {
	private static final String CLIENT_PATH = "/clients";

	@Autowired
	ClientRepository clientRepository;

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value = CLIENT_PATH, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<Client> getClients() {
		return clientRepository.findAll();
	}

	// @CrossOrigin(origins = "http://localhost:8080")
	// @RequestMapping(value = CLIENT_PATH, method = RequestMethod.GET)
	// public List<Client> getAllClients() {
	// return clientRepository.findAll();
	// }
}
