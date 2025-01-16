package org.example.dronepizzabackend.controller;

import org.example.dronepizzabackend.DTO.DroneDTO;
import org.example.dronepizzabackend.service.DroneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    private final DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    // Get all drones
    @GetMapping
    public ResponseEntity<List<DroneDTO>> getAllDrones() {
        List<DroneDTO> drones = droneService.getAllDrones();
        return ResponseEntity.ok(drones);
    }

    // Get a drone by ID
    @GetMapping("/{id}")
    public ResponseEntity<DroneDTO> getDroneById(@PathVariable Long id) {
        DroneDTO drone = droneService.getDroneById(id);
        return ResponseEntity.ok(drone);
    }

    // Create a new drone
    @PostMapping
    public ResponseEntity<DroneDTO> createDrone(@RequestBody DroneDTO droneDTO) {
        DroneDTO createdDrone = droneService.createDrone(droneDTO);
        return ResponseEntity.ok(createdDrone);
    }

    // Update an existing drone
    @PutMapping("/{id}")
    public ResponseEntity<DroneDTO> updateDrone(@PathVariable Long id, @RequestBody DroneDTO droneDTO) {
        DroneDTO updatedDrone = droneService.updateDrone(id, droneDTO);
        return ResponseEntity.ok(updatedDrone);
    }

    // Delete a drone by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(@PathVariable Long id) {
        droneService.deleteDrone(id);
        return ResponseEntity.noContent().build();
    }
}
