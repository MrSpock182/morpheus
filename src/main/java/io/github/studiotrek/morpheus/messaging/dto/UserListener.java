package io.github.studiotrek.morpheus.messaging.dto;

public class UserListener {
    private String name;

    public UserListener() {
    }

    public UserListener(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
