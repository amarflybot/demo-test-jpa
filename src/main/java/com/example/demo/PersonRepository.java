package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by amarendra on 01/09/17.
 */
@RepositoryRestResource
public interface PersonRepository  extends JpaRepository<Person, Long>{
}
