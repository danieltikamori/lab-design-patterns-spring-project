package cc.tkmr.labdesignpatternsspringproject.services;

import cc.tkmr.labdesignpatternsspringproject.models.Client;

/**
 * Interface that defines the <b>Strategy</b> in the client domain. With
 * this, if necessary, we can have multiple implementations of this same
 * interface.
 * 
 */
public interface ClientService {

	Iterable<Client> findAllClients();

	Client findByID(Long id);

	void insertClient(Client client);

	void updateClient(Long id, Client client);

	void deleteClient(Long id);

}
