package com.example.mygreetingsapp.repository;

import com.example.mygreetingsapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}