package ru.Harevich.Messanger.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Harevich.Messanger.entity.Person;
import ru.Harevich.Messanger.repository.PersonRepository;

import java.util.List;

@Service
@Transactional
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Transactional(readOnly = true)
    public List<Person> getAll(){
        return personRepository.findAll();
    }
}
