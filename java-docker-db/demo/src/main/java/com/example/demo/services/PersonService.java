package com.example.demo.services;

import com.example.demo.entities.Person;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    Person save(Person person);
    Optional<Person> findById(Long id);
    List<Person> findAll();
}
