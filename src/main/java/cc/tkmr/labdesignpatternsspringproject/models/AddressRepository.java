/*
 * @author Daniel Tikamori
 * Copyright (c) 2024. All rights reserved.
 */

package cc.tkmr.labdesignpatternsspringproject.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}
