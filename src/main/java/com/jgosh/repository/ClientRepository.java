package com.jgosh.repository;

import com.jgosh.domain.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gkamut on 2017-02-08.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
}
