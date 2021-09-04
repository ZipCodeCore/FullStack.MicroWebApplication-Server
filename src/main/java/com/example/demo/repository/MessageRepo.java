package com.example.demo.repository;

import com.example.demo.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {


    Iterable<Message> getMessageByChannel_Id(Long id);

}
