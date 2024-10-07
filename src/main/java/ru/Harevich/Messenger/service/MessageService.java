package ru.Harevich.Messenger.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Harevich.Messenger.entity.Message;
import ru.Harevich.Messenger.repository.MessengerRepository;

import java.util.List;

@Service
public class MessageService {
    private final MessengerRepository repository;

    public MessageService(MessengerRepository repository) {
        this.repository = repository;
    }
    public List<Message> get(){
        return repository.findAll();
    }

}
