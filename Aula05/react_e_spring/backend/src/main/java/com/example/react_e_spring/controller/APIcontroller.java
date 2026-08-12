package com.example.react_e_spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")

public class APIcontroller {
    @GetMapping("/saudacao")
    public Map<String, String> getDados() {
        return Map.of("msg", "Olá, React!");
    }
}
