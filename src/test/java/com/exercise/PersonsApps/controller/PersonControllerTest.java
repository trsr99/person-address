package com.exercise.PersonsApps.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.exercise.PersonsApps.AbstractTest;
import com.exercise.PersonsApps.model.Person;

public class PersonControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   
   @Test
   public void createPerson() throws Exception {
      String uri = "http://localhost:8088/api/person";
      Person person = new Person();
      person.setFirstName("Jack");
      person.setLastName("Ginger");
      String inputJson = super.mapToJson(person);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
   }
   
   @Test
   public void updatePerson() throws Exception {
      String uri = "http://localhost:8088/api/person/1";
      Person person = new Person();
      person.setFirstName("Lemon");
      String inputJson = super.mapToJson(person);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
   }
   
   @Test
   public void getPersonsList() throws Exception {
      String uri = "http://localhost:8088/api/person";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Person[] personlist = super.mapFromJson(content, Person[].class);
      assertTrue(personlist.length > 0);
   }
   
   @Test
   public void deletePerson() throws Exception {
      String uri = "http://localhost:8088/api/person/1";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
   }
}