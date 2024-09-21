package ru.Harevich.Messanger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.Harevich.Messanger.entity.Message;

public interface MessangerRepository extends MongoRepository<Message,String> {
    Message findBySender(String sender);
}
