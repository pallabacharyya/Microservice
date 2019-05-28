package com.tutorial.h2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;



@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    
    @HystrixCommand(fallbackMethod = "getAllPersonsHystrix", commandProperties = {
 		   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
 		})
    public List<Person> getAllPersons() throws InterruptedException {
    	Thread.sleep(3000);
        List<Person> persons = new ArrayList<Person>();
        personRepository.findAll().forEach(person -> persons.add(person));       
        return persons;
    	
    }
    
    public List<Person> getAllPersonsHystrix() {
    	 List<Person> listFall= new ArrayList<Person>();
    	Person p1= new Person();
		p1.setName("Palla");
		p1.setAge(99);
		listFall.add(p1);
        return listFall;
      }


    public Person getPersonById(int id) {
        return personRepository.findById(id).get();
    }

    @Transactional
    public void saveOrUpdate(Person person) {
    	System.out.println("inside saveOrUpdate");
        personRepository.save(person);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
    
    /*
     * @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
    		   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    		})
     */
}