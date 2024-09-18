package ru.Harevich.Messanger.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.Harevich.Messanger.entity.Person;
import ru.Harevich.Messanger.entity.User;
import ru.Harevich.Messanger.service.PersonService;
import ru.Harevich.Messanger.service.UserService;

import java.util.Collection;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final PersonService personService;

    public UserController(UserService userService, PersonService personService) {
        this.userService = userService;
        this.personService = personService;
    }

    @GetMapping("/hello")
    public Collection<Person> test(){
        return personService.getAll();
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
