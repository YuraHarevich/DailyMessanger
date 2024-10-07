package ru.Harevich.Messenger.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import ru.Harevich.Messenger.DTO.PersonDTO;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Node
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private int user_id;
    private LocalDateTime birthday;
    private boolean online;

    @Relationship("FRIEND")
    List<Person> friends;

    public PersonDTO toPersonDTO(){
        return new PersonDTO(id,name,surname,user_id,birthday,online);
    }
}