package ru.Harevich.Messanger.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import ru.Harevich.Messanger.DTO.PersonDTO;

import java.util.List;

@Node
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    public String username;

    @Relationship("FRIEND")
    List<Person> friend;

    public PersonDTO toPersonDTO(){
        return new PersonDTO(id,username);
    }
}