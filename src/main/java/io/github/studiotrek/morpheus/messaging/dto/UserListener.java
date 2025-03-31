package io.github.studiotrek.morpheus.messaging.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserListener {
    @JsonProperty
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
