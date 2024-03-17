/*
 * Author: Daniel Tikamori
 * Copyright (c) 2024. All rights reserved.
 */

// Define the package of the class.
package cc.tkmr.labdesignpatternsspringproject.services.impl;

// Import necessary classes.
import cc.tkmr.labdesignpatternsspringproject.models.Address;
import cc.tkmr.labdesignpatternsspringproject.models.AddressRepository;
import cc.tkmr.labdesignpatternsspringproject.models.Client;
import cc.tkmr.labdesignpatternsspringproject.models.ClientRepository;
import cc.tkmr.labdesignpatternsspringproject.services.ClientService;
import cc.tkmr.labdesignpatternsspringproject.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

/**
 * Implementation of the Strategy design pattern for the ClientService interface.
 * This class is annotated as a Spring Service, making it a Singleton.
 */
@Service
public class ClientServiceImpl implements ClientService {

	// Inject ClientRepository, AddressRepository, and ViaCepService components.
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ViaCepService viaCepService;

	// Implement methods defined in the ClientService interface.
	// Utilize the Facade design pattern to simplify subsystem integrations.

	@Override
	public Iterable<Client> findAllClients() {
		// Retrieve all Clients from the database.
		try {
			return clientRepository.findAll();
		} catch (Exception e) {
			// Log or handle the exception
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	public Client findByID(Long id) {
		// Find a Client by their ID.
		try {
			Optional<Client> client = clientRepository.findById(id);
			return client.orElseThrow(() -> new IllegalArgumentException("Client not found with id: " + id));
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			// Log or handle the exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insertClient(Client client) {
		// Insert a new Client into the system.
		try {
			saveClientWithZip(client);
		} catch (Exception e) {
			// Log or handle the exception
			e.printStackTrace();
		}
	}

	@Override
	public void updateClient(Long id, Client client) {
		// Update an existing Client in the database.
		try {
			Optional<Client> clientDb = clientRepository.findById(id);
			if (clientDb.isPresent()) {
				saveClientWithZip(client);
			} else {
				throw new IllegalArgumentException("Client not found with id: " + id);
			}
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			// Log or handle the exception
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClient(Long id) {
		// Delete a Client by their ID.
		try {
			clientRepository.deleteById(id);
		} catch (Exception e) {
			// Log or handle the exception
			e.printStackTrace();
		}
	}

	// Helper method to save a Client with associated Address.
	private void saveClientWithZip(Client client) {
		// Check if the address related to the Client already exists.
		try {
			String cep = client.getAddress().getCep();
			Address address = addressRepository.findById(cep).orElseGet(() -> {
				Address newAddress = viaCepService.consultCep(cep);
				addressRepository.save(newAddress);
				return newAddress;
			});
		// Associate the retrieved or existing Address with the Client.
		client.setAddress(address);
		// Save the Client information along with the linked Address.
		clientRepository.save(client);
		} catch (Exception e) {
			// Log or handle the exception
			e.printStackTrace();
		}
	}

}