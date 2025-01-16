package org.example.dronepizzabackend.controller;

import org.example.dronepizzabackend.DTO.DeliveryDTO;
import org.example.dronepizzabackend.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    // Get all deliveries
    @GetMapping
    public ResponseEntity<List<DeliveryDTO>> getAllDeliveries() {
        List<DeliveryDTO> deliveries = deliveryService.getAllDeliveries();
        return ResponseEntity.ok(deliveries);
    }

    // Get a delivery by ID
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> getDeliveryById(@PathVariable Long id) {
        DeliveryDTO delivery = deliveryService.getDeliveryById(id);
        return ResponseEntity.ok(delivery);
    }

    // Create a new delivery
    @PostMapping
    public ResponseEntity<DeliveryDTO> createDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        DeliveryDTO createdDelivery = deliveryService.createDelivery(deliveryDTO);
        return ResponseEntity.ok(createdDelivery);
    }

    // Update an existing delivery
    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDTO> updateDelivery(@PathVariable Long id, @RequestBody DeliveryDTO deliveryDTO) {
        DeliveryDTO updatedDelivery = deliveryService.updateDelivery(id, deliveryDTO);
        return ResponseEntity.ok(updatedDelivery);
    }

    // Delete a delivery by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }

}

