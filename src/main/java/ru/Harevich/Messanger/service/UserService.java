package ru.Harevich.Messanger.service;

import org.springframework.stereotype.Service;
import ru.Harevich.Messanger.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
