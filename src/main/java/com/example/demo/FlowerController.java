package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class FlowerController {
    private final FlowerRepository flowerRepository;

    public FlowerController(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Flower createTodo(@RequestBody Flower flower) {
        return flowerRepository.save(flower);
    }

    @GetMapping("/")
    public Iterable<Flower> getTodos() {
        return flowerRepository.findAll();
    }
}
