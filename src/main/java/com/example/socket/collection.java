package com.example.socket;

public class collection {
    private static collection ourInstance = new collection();

    public static collection getInstance() {
        return ourInstance;
    }

    private collection() {
    }
}
