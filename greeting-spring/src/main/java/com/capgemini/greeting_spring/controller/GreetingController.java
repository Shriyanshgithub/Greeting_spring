package com.capgemini.greeting_spring.controller;

import com.capgemini.greeting_spring.dto.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    Greeting greeting;

    @GetMapping("/get")
        public ResponseEntity<String> getHello(@RequestParam(value = "name", defaultValue = "Hello World") String name){
            return new ResponseEntity<String>(String.format("hello , %s!",name),HttpStatus.OK);
        }

        @PostMapping("/post")
       public ResponseEntity<Greeting> postHello(@RequestParam(value = "name" , defaultValue = "Hello World") String name){
        return new ResponseEntity<>(new Greeting("Hello from bridgeLabz"), HttpStatus.OK);
        }

        @PutMapping("/put/{name}")
      public ResponseEntity<Greeting> putHello(@PathVariable("name") String name){
        return new ResponseEntity<>(new Greeting("Hello " + name +" from BridgeLabz"),HttpStatus.OK);
        }

        @DeleteMapping("/delete/{name}")
        public ResponseEntity<Greeting> deleteHello(@PathVariable("name") String name){
         return new ResponseEntity<>(new Greeting("Delete " + name + " from Bridgelabz"),HttpStatus.OK);
        }
}
