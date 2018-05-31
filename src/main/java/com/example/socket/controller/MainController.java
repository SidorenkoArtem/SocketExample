package com.example.socket.controller;

import com.example.socket.model.AnswerMessage;
import com.example.socket.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @MessageMapping("/main")
    @SendTo("/topic/message")
    public AnswerMessage message(Message message) throws Exception {
        Thread.sleep(500);
        return new AnswerMessage( message.getMessageText() + ": " + message.getMessage());
    }
}
