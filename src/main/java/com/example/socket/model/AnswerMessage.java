package com.example.socket.model;

import lombok.Builder;
import lombok.Data;

@Data
public class AnswerMessage {
    private String userName;
    private final String context;

    @Builder
    public AnswerMessage(final String context) {
        this.context = context;
    }
}
