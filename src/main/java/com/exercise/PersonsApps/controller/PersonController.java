package com.exercise.PersonsApps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.PersonsApps.exceptions.CustomException;
import com.exercise.PersonsApps.model.Person;
import com.exercise.PersonsApps.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
	//autowired the PersonService class  
	@Autowired  
	PersonService personService;  
	
	//creating a get mapping that retrieves all the person detail from the database   
	@GetMapping("/person")  
	private List<Person> getAllPerson()   
	{
		List<Person> p;
		try {
			p = personService.getAllPerson();
			if (p.isEmpty()) {
				throw new CustomException("NO_RECORDS","Records not found.");
			}
		} catch(Exception ex) {
			throw new CustomException("BAD_REQUEST","Bad Request to get list of records.");
		}
		return p; 
	}
	
	//count the number of persons
	@GetMapping("/personcount")  
	private int getPersonCount()   
	{  
	return personService.getAllPerson().size();  
	}
	
	//creating a get mapping that retrieves the detail of a specific person  
	@GetMapping("/person/{id}")  
	private Person getPerson(@PathVariable("id") int id)   
	{
		Person p;
		try {
			p = personService.getPersonById(id);
		} catch(Exception ex) {
			throw new CustomException("RECORD_NOT_FOUND","Record not found for Id : " + id);
		}
		return p; 
	}  
	
	//creating a delete mapping that deletes a specific person  
	@DeleteMapping("/person/{id}")  
	private void deletePerson(@PathVariable("id") int id)   
	{  
		try {
			personService.delete(id);
		} catch(Exception ex) {
			throw new CustomException("RECORD_NOT_FOUND","No Record to delete for Id : " + id);
		}
	}
	
	//creating post mapping that post the person detail in the database  
	@PostMapping("/person")  
	private int savePerson(@RequestBody Person person)   
	{  
		try {
			personService.saveOrUpdate(person); 
		} catch(Exception ex) {
			throw new CustomException("BAD_REQUEST","Unable to update/create.");
		}
		return person.getId();  
	}
}
