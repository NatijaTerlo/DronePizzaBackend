package org.example.service;

import org.example.dronepizzabackend.DTO.PizzaDTO;
import org.example.dronepizzabackend.impl.PizzaServiceImpl;
import org.example.dronepizzabackend.model.Pizza;
import org.example.dronepizzabackend.repositories.PizzaRepository;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PizzaServiceTest {

    @Mock
    private PizzaRepository pizzaRepository;

    @InjectMocks
    private PizzaServiceImpl pizzaService;

    @Test
    public void testGetAllPizzas() {
        // Arrange
        List<Pizza> pizzas = List.of(new Pizza("Margherita", 70));
        Mockito.when(pizzaRepository.findAll()).thenReturn(pizzas);

        // Act
        List<PizzaDTO> result = pizzaService.getAllPizzas();

        // Assert
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Margherita", result.get(0).getTitle());
    }
}
