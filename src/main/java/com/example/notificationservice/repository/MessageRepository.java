package com.example.notificationservice.repository;

import com.example.notificationservice.domain.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByAccountGuid(String accountGuid);
}
