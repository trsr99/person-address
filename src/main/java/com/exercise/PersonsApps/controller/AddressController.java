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
import com.exercise.PersonsApps.model.Address;
import com.exercise.PersonsApps.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressController {
	//autowired the AddressService class  
	@Autowired  
	AddressService addressService;  
	
	//creating a get mapping that retrieves all the address detail from the database   
	@GetMapping("/address")  
	private List<Address> getAllAddress()   
	{
		List<Address> a;
		try {
			a = addressService.getAllAddress();
			if (a.isEmpty()) {
				throw new CustomException("NO_RECORDS","Records not found.");
			}
		} catch(Exception ex) {
			throw new CustomException("NO_RECORDS","Records not found.");
		}
		return a;
	}  
	
	//creating a get mapping that retrieves the detail of a specific address  
	@GetMapping("/address/{id}")  
	private Address getAddress(@PathVariable("id") int id)   
	{
		Address a;
		try {
			a = addressService.getAddressById(id);
		} catch(Exception ex) {
			throw new CustomException("RECORD_NOT_FOUND","Record not found for Id : " + id);
		}
		return a;  
	}  
	
	//creating a delete mapping that deletes a specific address  
	@DeleteMapping("/address/{id}")  
	private void deleteAddress(@PathVariable("id") int id)   
	{  
		try {
			addressService.delete(id);
		} catch(Exception ex) {
			throw new CustomException("RECORD_NOT_FOUND","No Record to delete for Id : " + id);
		}
	}
	
	//creating post mapping that post the address detail in the database  
	@PostMapping("/address")  
	private int saveAddress(@RequestBody Address address)   
	{  
		try {
			addressService.saveOrUpdate(address);
		} catch(Exception ex) {
			throw new CustomException("BAD_REQUEST","Unable to update/create.");
		}
		return address.getId();  
	}  
}
