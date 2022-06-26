package com.example.springdatadb;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/specification")
public class SpecificationBirdController {
    BirdRepository birdRepository;
    @GetMapping("/birds")
    public List<Bird> getBirdList(){

    }
}
