package com.example.mygreetingsapp.controller;


import com.example.mygreetingsapp.dto.GreetingRequest;
import com.example.mygreetingsapp.model.Greeting;
import com.example.mygreetingsapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public String hello() {
        return greetingService.sayHello();
    }

    @GetMapping("/hello/query")
    public String helloQuery(@RequestParam String name) {
        return greetingService.sayHello(name);
    }

    @GetMapping("/hello/{name}")
    public String helloPath(@PathVariable String name) {
        return greetingService.sayHello(name);
    }

    @PostMapping("/hello/body")
    public String helloBody(@RequestBody GreetingRequest request) {
        return greetingService.sayHello(request.getName());
    }

    @PostMapping("/greetings")
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @GetMapping("/greetings/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {

        return greetingService.getGreetingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/greetings/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {

        greetingService.deleteGreeting(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/greetings/{id}")
    public ResponseEntity<Greeting> updateGreeting(
            @PathVariable Long id,
            @RequestBody Greeting greeting) {

        return greetingService.updateGreeting(id, greeting)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}