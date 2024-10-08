package ru.Harevich.Messenger.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Harevich.Messenger.entity.Person;
import ru.Harevich.Messenger.repository.PersonRepository;

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
    public void createPerson(Person person){
        personRepository.save(person);
    }
}
