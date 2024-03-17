/*
 * @author Daniel Tikamori
 * Copyright (c) 2024. All rights reserved.
 */

package cc.tkmr.labdesignpatternsspringproject.controllers;

import cc.tkmr.labdesignpatternsspringproject.models.Client;
import cc.tkmr.labdesignpatternsspringproject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * This {@link RestController} represents our <b>Facade</b>, because it abstracts the whole
 * complexity of integrations (H2 database and ViaCEP API) in a
 * simple and cohesive interface (API REST).
 *
 * This class represents the REST API controller for managing clients.
 *
 * This RestController acts as a Facade, abstracting the complexity of integrations (H2 database and ViaCEP API) into a simple and cohesive REST API interface.
 */
@RestController
@RequestMapping("clients")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    /**
     * Get mapping for retrieving all clients.
     * @return ResponseEntity with a collection of Client objects
     */
    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    /**
     * Get mapping for retrieving a client by id.
     * @param id The id of the client to retrieve
     * @return ResponseEntity with the Client object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Client> findByID(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findByID(id));
    }

    /**
     * Post mapping for inserting a new client.
     * @param client The client object to insert
     * @return ResponseEntity with the inserted Client object
     */
    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client) {
        clientService.insertClient(client);
        return ResponseEntity.ok(client);
    }

    /**
     * Put mapping for updating an existing client.
     * @param id The id of the client to update
     * @param client The updated client object
     * @return ResponseEntity with the updated Client object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        clientService.updateClient(id, client);
        return ResponseEntity.ok(client);
    }

    /**
     * Delete mapping for deleting a client by id.
     * @param id The id of the client to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}