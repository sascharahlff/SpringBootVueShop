package de.itemis.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.itemis.auth.domain.Client;
import de.itemis.auth.repository.ClientRepository;

@Service
public class ClientServiceImp implements ClientService {
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client findByName(String name) {
		return clientRepository.findByName(name);
	}
}
