package com.exercise.PersonsApps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.PersonsApps.model.Address;
import com.exercise.PersonsApps.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired  
	AddressRepository addressRepository;
	
	//getting all address records  
	public List<Address> getAllAddress()   
	{  
	List<Address> address = new ArrayList<Address>();  
	addressRepository.findAll().forEach(addr -> address.add(addr));  
	return address;  
	}
	
	//getting a specific record  
	public Address getAddressById(int id)   
	{  
	return addressRepository.findById(id).get();  
	}
	
	public void saveOrUpdate(Address address)   
	{  
		addressRepository.save(address);  
	}
	
	//deleting a specific record  
	public void delete(int id)   
	{  
		addressRepository.deleteById(id);  
	}  

}
