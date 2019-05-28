package com.tutorial.h2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    private List<Person> getAllPersons() {
    	try {
        return personService.getAllPersons();
    	} catch(Exception e) {
			/*
			 * List<Person> list1= new ArrayList<Person>(); e.printStackTrace(); Person p1=
			 * new Person(); p1.setName("hystrix1"); p1.setAge(11); list1.add(p1); return
			 * list1;
			 */
    		
    	}
    	return null;
    }

    @GetMapping("/persons/{id}")
    private Person getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @PostMapping("/persons")
    private int savePerson(@RequestBody Person person) {
    	System.out.println("inside savePerson");
        personService.saveOrUpdate(person);
        return person.getId();
    }
}