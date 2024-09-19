package ru.Harevich.Messenger.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Harevich.Messenger.DTO.PersonDTO;
import ru.Harevich.Messenger.entity.Person;
import ru.Harevich.Messenger.entity.User;
import ru.Harevich.Messenger.service.PersonService;
import ru.Harevich.Messenger.service.UserService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private final UserService userService;
    private final PersonService personService;

    public UserController(UserService userService, PersonService personService) {
        this.userService = userService;
        this.personService = personService;
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

}
