package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Получение списка всех людей
    @GetMapping
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    // Создание нового человека
    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
}
