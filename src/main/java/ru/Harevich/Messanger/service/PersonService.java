package ru.Harevich.Messanger.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Harevich.Messanger.entity.Person;
import ru.Harevich.Messanger.repository.PersonRepository;

import java.util.List;

@Service
@Transactional("transactionManagerNeo4j")
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }
}
