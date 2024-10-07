package ru.Harevich.Messenger.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Harevich.Messenger.DTO.PersonDTO;
import ru.Harevich.Messenger.entity.Message;
import ru.Harevich.Messenger.entity.Person;
import ru.Harevich.Messenger.entity.User;
import ru.Harevich.Messenger.service.MessageService;
import ru.Harevich.Messenger.service.PersonService;
import ru.Harevich.Messenger.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final UserService userService;
    private final PersonService personService;
    private final MessageService messageService;

    public UserController(UserService userService, PersonService personService, MessageService messageService) {
        this.userService = userService;
        this.personService = personService;
        this.messageService = messageService;
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") User user){
        return "/registration";
    }
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid User user,
                                      BindingResult bindingResult){
        //userValidator.validate(user,bindingResult);
        String password = user.getPassword();;
        if(bindingResult.hasErrors())
            return "/registration";
        userService.registrate(user);
        return "/home";

    }



    @PostMapping("/after-registration")
    public String savePerson(@ModelAttribute("person")Person person){
        personService.createPerson(person);
        //exception

       return "redirect:/login";
    }
    @GetMapping("/after-registration/{username}")
    public String afterReg(@PathVariable("username")String username,
                           Model model){
        Person person = new Person();
        person.setUser_id(userService.findByUsername(username).get().getId());
        ////
        ////exception
        ////
        model.addAttribute("person",person);
        return "after-registration";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/friends")
    public String friends(){
        return "friends";
    }
    @GetMapping("/explore")
    public String explore(){
        return "explore";
    }
    @GetMapping("/settings")
    public String settings(){
        return "settings";
    }
    @GetMapping("/pre-registration")
    public String preRegistration(){
        return "pre-registration";
    }
    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

}
