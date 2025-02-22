package com.capgemini.greeting_spring.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getServiceMessage(){
        return "hello world";
    }
}
