package ru.Harevich.Messanger.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Harevich.Messanger.DTO.PersonDTO;
import ru.Harevich.Messanger.entity.Message;
import ru.Harevich.Messanger.entity.Person;
import ru.Harevich.Messanger.entity.User;
import ru.Harevich.Messanger.service.MessageService;
import ru.Harevich.Messanger.service.PersonService;
import ru.Harevich.Messanger.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final UserService userService;
    private final PersonService personService;
    private final MessageService messageService;

    public UserController(UserService userService, PersonService personService, MessageService messageService) {
        this.userService = userService;
        this.personService = personService;
        this.messageService = messageService;
    }

    @GetMapping("hello")
    public List<PersonDTO> test(){
        return personService.getAll().stream().map(Person::toPersonDTO).collect(Collectors.toList());
    }
    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") User user){
        return "/registration";
    }
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user,
                                      BindingResult bindingResult){
        //userValidator.validate(user,bindingResult);
        if(bindingResult.hasErrors())
            return "/registration";
        userService.registrate(user);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("message")
    public List<Message> getMessages(){
        return messageService.get();
    }
    @GetMapping("message/{sender}")
    public Message getMessages(@PathVariable("sender")String sender){
        return messageService.getBySender(sender);
    }

}
