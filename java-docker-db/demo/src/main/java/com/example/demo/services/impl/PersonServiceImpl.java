package com.example.demo.services.impl;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository repository;
    public PersonServiceImpl(PersonRepository repository){this.repository=repository;}
    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }
}
