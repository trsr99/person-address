package com.exercise.PersonsApps.repository;

import org.springframework.data.repository.CrudRepository;

import com.exercise.PersonsApps.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
