package ru.Harevich.Messanger.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import ru.Harevich.Messanger.entity.Person;

public interface PersonRepository extends Neo4jRepository<Person,Long> {
}
