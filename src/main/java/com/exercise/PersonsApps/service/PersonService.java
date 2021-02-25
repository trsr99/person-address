package com.exercise.PersonsApps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.PersonsApps.model.Person;
import com.exercise.PersonsApps.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired  
	PersonRepository personRepository;
	
	//getting all address records  
	public List<Person> getAllPerson()   
	{  
	List<Person> person = new ArrayList<Person>();  
	personRepository.findAll().forEach(pers -> person.add(pers));  
	return person;  
	}
	
	//getting a specific record  
	public Person getPersonById(int id)   
	{  
	return personRepository.findById(id).get();  
	}
	
	public void saveOrUpdate(Person person)   
	{  
		personRepository.save(person);  
	}
	
	//deleting a specific record  
	public void delete(int id)   
	{  
		personRepository.deleteById(id);  
	}  

}
