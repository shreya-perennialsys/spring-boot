package com.howtodoinjava.demo.person.dao;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.person.Repository.PersonRepository;
import com.howtodoinjava.demo.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/**
 *
 * @auther shreya
 */
public class PersonDao {
    @Autowired
    PersonRepository repository;

    /**
     * Add Person
     * @param person
     */
    public void addPerson(Person person) {
        repository.save(person);
    }

    /**
     * To validate record
     * @param emial
     * @param password
     * @return
     */
    public Person validateRecord(String emial, String password) {
        List<Person> personList = repository.findAll();
        for (Person person : personList) {
            if (person.getEmail().equalsIgnoreCase(emial) && person.getPassword().equals(password)) {
                return person;
            }
        }
        return null;
    }

    public void getRecord(Long id)
    {
        Person person = repository.getOne(id);
        repository.delete(person);

    }

    public Person getUpdatedRecord(Long pid) {
        Person person = repository.getOne(pid);
        return person;
    }
    public Person updateCourse(Person person) {
        repository.save(person);
        return person;
    }
}

