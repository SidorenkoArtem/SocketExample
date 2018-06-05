package com.example.socket.model;

import javax.persistence.*;

@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

//    @Column(name = "user")
//    private String user;

    public Conversation(Long id/*, String user*/) {
        this.id = id;
//        this.user = user;
    }

    public Conversation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(final String user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                '}';
    }
}
