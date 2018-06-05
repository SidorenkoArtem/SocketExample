package com.example.socket.restController;

import com.example.socket.model.Conversation;
import com.example.socket.service.ConversationService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping(value = "/conversation", produces = "application/json")
public class ConversationController {

    private ConversationService conversationService;

    @GetMapping("/{idConversation}")
    public Conversation getConversation(@RequestParam(value = "idConversation") Long idConversation) {
        return conversationService.getConversation();
    }
}
