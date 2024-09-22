package ru.Harevich.Messenger.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import ru.Harevich.Messenger.entity.Person;

public interface PersonRepository extends Neo4jRepository<Person,Long> {
}
