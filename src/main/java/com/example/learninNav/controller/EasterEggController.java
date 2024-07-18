package com.example.learninNav.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learninNav.service.NumberApiService;

@RestController
@RequestMapping("/hidden-feature")
public class EasterEggController {
    
    @Autowired
    private NumberApiService numberApiService;

    @GetMapping("/{number}")
    public ResponseEntity<String> getFactForNumber(@PathVariable("number") int num) {
            String numberResponse = numberApiService.getFactForNumber(num);
            return ResponseEntity.ok().body(numberResponse);

        
    }
}
