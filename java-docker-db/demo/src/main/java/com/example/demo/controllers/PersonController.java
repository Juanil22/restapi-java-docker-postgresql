package com.example.demo.controllers;

import com.example.demo.dtos.PersonDTO;
import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }
    @PostMapping
    public ResponseEntity<Person> save (@RequestBody PersonDTO personDTO){
        Person person=Person.builder().name(personDTO.getName()).mail(personDTO.getMail()).build();
        Person persistedPerson= personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(persistedPerson);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id){
        Optional<Person> personOpt= personService.findById(id);
        if (personOpt.isPresent()){
            return ResponseEntity.ok(personOpt.get());
        }
        return  ResponseEntity.ok(null);
    }



}
