# Coding Challange

Person-Address project demonstrates the basic Rest services support for all DML operations on Entities(PERSON, ADDRESS) useing H2Database as in-memory Database. 

# Maven Build & Jar execution
- Execute the project as maven build
- go through the .pom directory of project and run MVN clean install to generate jar file with target folder.
- - normal build to skip test , mvn clean install -DskipTests=true
- - build with unit tests , mvn clean install
- go through the target directory run the following command with command prompt, 
  java -jar person-address-0.0.1-SNAPSHOT.jar then springboot project runs at 8088 port.

# Rest Services
## Persons entity
Create: POST ==> http://localhost:8088/api/person
{
  "firstName":"Raj",
  "lastName":"tetala"
}

Delete: DEL ==> http://localhost:8088/api/person/1

Create: POST ==> http://localhost:8088/api/person
JSON Request:
{
  "firstName":"Raj",
  "lastName":"tetala"
}

Create: POST ==> http://localhost:8088/api/person
JSON Request:
{
  "firstName":"Rajsekhar",
  "lastName":"tetala"
}

Update: POST ==> http://localhost:8088/api/person
JSON Request:
{
  "id":3,
  "firstName":"RajsekharT",
  "lastName":"tetala"
}

Specific Record: GET ==> http://localhost:8088/api/person/2

All records: GET ==> http://localhost:8088/api/person

## Address entity
CREATE: POST ==> http://localhost:8088/api/address
JSON Request:
{"street":"Street One",
 "city":"Hyderabad",
 "state":"Telanagana",
 "postalCode":"500047",
 "person":{"id":1,
		   "firstName":"RajsekharT",
		   "lastName":"tetala"}
  }
  
CREATE: POST ==> http://localhost:8088/api/address
JSON Request:
{"street":"Street Two",
 "city":"Hyderabad",
 "state":"Telanagana",
 "postalCode":"500047",
 "person":{"id":1}
  }

Delete: ==> http://localhost:8088/api/address/7

Update: POST ==> http://localhost:8088/api/address
JSON Request:
{"id":"8",
 "street":"Street One",
 "city":"Hyderabad",
 "state":"Telanagana",
 "postalCode":"500147"
 }
 
Specific Record: GET ==> http://localhost:8088/api/address/8

All records: GET ==> http://localhost:8088/api/address