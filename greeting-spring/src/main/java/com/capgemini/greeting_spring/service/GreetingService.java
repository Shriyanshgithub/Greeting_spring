package com.capgemini.greeting_spring.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getServiceMessage(){
        return "hello world";
    }

    public String getGreetingMessage(String firstName ,String lastName){
        if(firstName != null && lastName != null ){
            return "First name : " + firstName + " LastName : " + lastName;
        } else if(firstName != null) {
            return "First name : " + firstName;
        } else if(lastName != null) {
            return "Last name : " + lastName;
        }
        else {
            return "hello world";
        }
    }
}
