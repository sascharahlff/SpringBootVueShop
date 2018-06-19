package de.itemis.auth.service;

import de.itemis.auth.domain.Client;

public interface ClientService {
	Client findByName(String name);
}
