package com.capgemini.greeting_spring.dto;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

@Component
public class Greeting {
    private String message;

    public Greeting(){}
    public Greeting(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
