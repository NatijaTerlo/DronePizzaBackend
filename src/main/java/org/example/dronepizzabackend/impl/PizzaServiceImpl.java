package org.example.dronepizzabackend.impl;

import org.example.dronepizzabackend.DTO.PizzaDTO;
import org.example.dronepizzabackend.model.Pizza;
import org.example.dronepizzabackend.repositories.PizzaRepository;
import org.example.dronepizzabackend.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public List<PizzaDTO> getAllPizzas() {
        return pizzaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PizzaDTO getPizzaById(Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found with ID: " + id));
        return convertToDTO(pizza);
    }

    @Override
    public PizzaDTO createPizza(PizzaDTO pizzaDTO) {
        Pizza pizza = convertToEntity(pizzaDTO);
        Pizza savedPizza = pizzaRepository.save(pizza);
        return convertToDTO(savedPizza);
    }

    @Override
    public PizzaDTO updatePizza(Long id, PizzaDTO pizzaDTO) {
        Pizza existingPizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found with ID: " + id));
        existingPizza.setTitel(pizzaDTO.getTitle());
        existingPizza.setPris(pizzaDTO.getPrice());
        Pizza updatedPizza = pizzaRepository.save(existingPizza);
        return convertToDTO(updatedPizza);
    }

    @Override
    public void deletePizza(Long id) {
        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza not found with ID: " + id));
        pizzaRepository.delete(pizza);
    }

    // Helper methods to convert between DTO and Entity
    private PizzaDTO convertToDTO(Pizza pizza) {
        PizzaDTO dto = new PizzaDTO();
        dto.setId(pizza.getPizzaId());
        dto.setTitle(pizza.getTitel());
        dto.setPrice(pizza.getPris());
        return dto;
    }

    private Pizza convertToEntity(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setPizzaId(pizzaDTO.getId());
        pizza.setTitel(pizzaDTO.getTitle());
        pizza.setPris(pizzaDTO.getPrice());
        return pizza;
    }
}

