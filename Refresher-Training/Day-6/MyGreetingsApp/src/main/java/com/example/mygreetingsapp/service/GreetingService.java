package com.example.mygreetingsapp.service;

import com.example.mygreetingsapp.model.Greeting;
import com.example.mygreetingsapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String sayHello() {
        return "Hello World";
    }

    public String sayHello(String name) {
        return "Hello " + name;
    }


    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }

    public Optional<Greeting> updateGreeting(Long id, Greeting updatedGreeting) {

        return greetingRepository.findById(id)
                .map(existingGreeting -> {

                    existingGreeting.setMessage(updatedGreeting.getMessage());

                    return greetingRepository.save(existingGreeting);
                });
    }
}