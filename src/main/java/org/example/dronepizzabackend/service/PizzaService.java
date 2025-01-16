package org.example.dronepizzabackend.service;

import org.example.dronepizzabackend.DTO.PizzaDTO;

import java.util.List;

public interface PizzaService {
    List<PizzaDTO> getAllPizzas();
    PizzaDTO getPizzaById(Long id);
    PizzaDTO createPizza(PizzaDTO pizzaDTO);
    PizzaDTO updatePizza(Long id, PizzaDTO pizzaDTO);
    void deletePizza(Long id);
}
