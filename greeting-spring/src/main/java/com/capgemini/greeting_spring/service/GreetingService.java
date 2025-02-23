package com.capgemini.greeting_spring.service;

import com.capgemini.greeting_spring.entity.GreetingEntity;
import com.capgemini.greeting_spring.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class GreetingService {

    private GreetingRepo greetingRepo;

    @Autowired
    public GreetingService(GreetingRepo greetingRepo){
        this.greetingRepo = greetingRepo;
    }


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

    public GreetingEntity saveGreetingInRepo(String message){
        GreetingEntity greetingEntity = new GreetingEntity(message);
        return greetingRepo.save(greetingEntity);
    }

    public List<GreetingEntity> getAll(){
        return greetingRepo.findAll();
    }
}
