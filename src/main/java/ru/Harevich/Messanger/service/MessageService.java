package ru.Harevich.Messanger.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Harevich.Messanger.entity.Message;
import ru.Harevich.Messanger.repository.MessangerRepository;

import java.util.List;

@Service
@Transactional("transactionManagerMongo")
public class MessageService {
    private final MessangerRepository repository;

    public MessageService(MessangerRepository repository) {
        this.repository = repository;
    }
    public List<Message> get(){
        return repository.findAll();
    }
    public Message getBySender(String sender){
        return repository.findBySender(sender);
    }
}
