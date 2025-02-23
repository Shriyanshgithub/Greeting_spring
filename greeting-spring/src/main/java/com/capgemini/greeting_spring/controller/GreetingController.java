package com.capgemini.greeting_spring.controller;

import com.capgemini.greeting_spring.dto.Greeting;
import com.capgemini.greeting_spring.entity.GreetingEntity;
import com.capgemini.greeting_spring.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    private final GreetingService greetingService;
    //dependency injection of service class
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;

    }


    Greeting greeting;

    //get mapping
    @GetMapping("/get")
        public ResponseEntity<String> getHello(@RequestParam(value = "name", defaultValue = "Hello World") String name){
            return new ResponseEntity<String>(String.format("hello , %s!",name),HttpStatus.OK);
        }

        //post mapping
        @PostMapping("/post")
       public ResponseEntity<Greeting> postHello(@RequestParam(value = "name" , defaultValue = "Hello World") String name){
        return new ResponseEntity<>(new Greeting("Hello from bridgeLabz"), HttpStatus.OK);
        }

        //put mapping
        @PutMapping("/put/{name}")
      public ResponseEntity<Greeting> putHello(@PathVariable("name") String name){
        return new ResponseEntity<>(new Greeting("Hello " + name +" from BridgeLabz"),HttpStatus.OK);
        }

        //delete mapping
        @DeleteMapping("/delete/{name}")
        public ResponseEntity<Greeting> deleteHello(@PathVariable("name") String name){
         return new ResponseEntity<>(new Greeting("Delete " + name + " from Bridgelabz"),HttpStatus.OK);
        }

      //Use case 2
    @GetMapping("/hello")
    public ResponseEntity<Greeting> getHelloService(){
        String message = greetingService.getServiceMessage();
        return new ResponseEntity<>(new Greeting(message),HttpStatus.OK);
    }

    //Use case 3
    @GetMapping("/hellogreeting/{firstName}/{lastName}")
     public ResponseEntity<Greeting> getFirstLastName(
             @PathVariable("firstName") String firstName,
             @PathVariable("lastName")String lastName){

        String message = greetingService.getGreetingMessage(firstName,lastName);
        return new ResponseEntity<>(new Greeting(message),HttpStatus.OK);
    }

    //Use case 4
    @PostMapping("/save/{message}")
    public ResponseEntity<GreetingEntity> saveGreeting(@PathVariable("message") String message){
        GreetingEntity saveMessage = greetingService.saveGreetingInRepo(message);
        return new ResponseEntity<>(saveMessage,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GreetingEntity>> getAllGreetingMessage(){
        List<GreetingEntity> greetingEntities = greetingService.getAll();
        return new ResponseEntity<>(greetingEntities, HttpStatus.OK);
    }

    //use case 5
    @GetMapping("/getMessage/{id}")
    public ResponseEntity<GreetingEntity> getMessageById(@PathVariable("id") Long id){
        GreetingEntity entity = greetingService.getMessageById(id);
        return new ResponseEntity<>(entity,HttpStatus.OK);
    }

}