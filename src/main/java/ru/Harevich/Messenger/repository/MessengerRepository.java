package ru.Harevich.Messenger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.Harevich.Messenger.entity.Message;

public interface MessengerRepository extends MongoRepository<Message,String> {
    Message findBySender(String sender);
}
