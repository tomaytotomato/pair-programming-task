package com.refactoring.example;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Service {

    private final TennisGame match = new TennisGame("Alice", "Bob");

    @GetMapping("/score/and/get/result/{name}")
    public ResponseEntity<String> score(@PathVariable String name) {
        match.wonPoint(name);
        return ResponseEntity.ok(match.getScore());
    }
}
