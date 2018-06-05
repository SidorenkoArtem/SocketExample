package com.example.socket.controller;

import com.example.socket.collection;
import com.example.socket.model.AnswerMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {

    @PostMapping
    public List<AnswerMessage> sendMessages() {
        return collection.messages;
    }

}
