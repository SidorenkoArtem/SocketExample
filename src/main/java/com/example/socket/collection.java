package com.example.socket;

import com.example.socket.model.AnswerMessage;
import java.util.ArrayList;
import java.util.List;

public class collection {
    public static List<AnswerMessage> messages;

    static {
        messages = new ArrayList<>();
    }

    public static void addMessage(AnswerMessage message) {
        messages.add(message);
    }

}
