package com.exercise.PersonsApps.repository;

import org.springframework.data.repository.CrudRepository;

import com.exercise.PersonsApps.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>  {

}
