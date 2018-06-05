package com.example.socket.controller;

import com.example.socket.model.Conversation;
import com.example.socket.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private ConversationRepository conversationRepository;

    @RequestMapping("/login")
    public String login(Model model) {
        Conversation conversation = new Conversation();
        //conversation.setUser("Nick");
        conversationRepository.save(conversation);
        return "login";
    }
}
