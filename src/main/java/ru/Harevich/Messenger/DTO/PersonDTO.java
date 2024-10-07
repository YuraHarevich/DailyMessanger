package ru.Harevich.Messenger.DTO;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String surname;
    private int user_id;
    private LocalDateTime birthday;
    private boolean online;

}
