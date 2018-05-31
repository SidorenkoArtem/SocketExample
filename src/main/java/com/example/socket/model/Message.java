package com.example.socket.model;

public class Message {
    private String messageText;
    private String messag;

    public Message() {
    }

    public Message(String messageText, final String messag) {
        this.messageText = messageText;
        this.messag = messag;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessag() {
        return this.messag;
    }

    public void setMessag(final String messag) {
        this.messag = messag;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                "message = '" + messag + '\'' +
                '}';
    }
}
