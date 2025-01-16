package org.example.dronepizzabackend.controller;

import org.example.dronepizzabackend.DTO.PizzaDTO;

import org.example.dronepizzabackend.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    // Get all pizzas
    @GetMapping
    public ResponseEntity<List<PizzaDTO>> getAllPizzas() {
        List<PizzaDTO> pizzas = pizzaService.getAllPizzas();
        return ResponseEntity.ok(pizzas);
    }

    // Get a pizza by ID
    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> getPizzaById(@PathVariable Long id) {
        PizzaDTO pizza = pizzaService.getPizzaById(id);
        return ResponseEntity.ok(pizza);
    }

    // Create a new pizza
    @PostMapping
    public ResponseEntity<PizzaDTO> createPizza(@RequestBody PizzaDTO pizzaDTO) {
        PizzaDTO createdPizza = pizzaService.createPizza(pizzaDTO);
        return ResponseEntity.ok(createdPizza);
    }

    // Update an existing pizza
    @PutMapping("/{id}")
    public ResponseEntity<PizzaDTO> updatePizza(@PathVariable Long id, @RequestBody PizzaDTO pizzaDTO) {
        PizzaDTO updatedPizza = pizzaService.updatePizza(id, pizzaDTO);
        return ResponseEntity.ok(updatedPizza);
    }

    // Delete a pizza by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }
}

