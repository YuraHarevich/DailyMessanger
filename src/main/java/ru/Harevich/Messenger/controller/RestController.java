package ru.Harevich.Messenger.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Harevich.Messenger.DTO.PersonDTO;
import ru.Harevich.Messenger.entity.Message;
import ru.Harevich.Messenger.entity.Person;
import ru.Harevich.Messenger.entity.User;
import ru.Harevich.Messenger.service.MessageService;
import ru.Harevich.Messenger.service.PersonService;
import ru.Harevich.Messenger.service.UserService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {
    private final UserService userService;
    private final PersonService personService;
    private final MessageService messageService;

    public RestController(UserService userService, PersonService personService, MessageService messageService) {
        this.userService = userService;
        this.personService = personService;
        this.messageService = messageService;
    }

    @GetMapping("hello")
    public List<PersonDTO> test(){
        return personService.getAll().stream().map(Person::toPersonDTO).collect(Collectors.toList());
    }

    @GetMapping("message")
    public List<Message> getMessages(){
        return messageService.get();
    }

    @GetMapping("time/{id}")
    public String getTime(@PathVariable("id") int id){
        Optional<User> user_opt = userService.findById(id);
        if(user_opt.isPresent())
            return user_opt.get().getCreated_at().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        else
            return null;
    }
}
