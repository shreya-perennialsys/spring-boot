package com.howtodoinjava.demo.person.Repository;

import com.howtodoinjava.demo.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
