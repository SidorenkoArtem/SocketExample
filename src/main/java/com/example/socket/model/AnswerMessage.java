package com.example.socket.model;

public class AnswerMessage {
    private String context;

    public AnswerMessage() {
    }

    public AnswerMessage(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "AnswerMessage{" +
                "context='" + context + '\'' +
                '}';
    }
}
