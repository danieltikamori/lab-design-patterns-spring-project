/*
 * @author Daniel Tikamori
 * Copyright (c) 2024. All rights reserved.
 */

package cc.tkmr.labdesignpatternsspringproject.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Make explicit that this class is a repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
