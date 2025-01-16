package org.example.dronepizzabackend.controller;

import org.example.dronepizzabackend.DTO.StationDTO;
import org.example.dronepizzabackend.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public ResponseEntity<List<StationDTO>> getAllStations() {
        List<StationDTO> stations = stationService.getAllStations();
        return ResponseEntity.ok(stations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StationDTO> getStationById(@PathVariable Long id) {
        StationDTO station = stationService.getStationById(id);
        return ResponseEntity.ok(station);
    }

    @PostMapping
    public ResponseEntity<StationDTO> createStation(@RequestBody StationDTO stationDTO) {
        StationDTO createdStation = stationService.createStation(stationDTO);
        return ResponseEntity.ok(createdStation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StationDTO> updateStation(@PathVariable Long id, @RequestBody StationDTO stationDTO) {
        StationDTO updatedStation = stationService.updateStation(id, stationDTO);
        return ResponseEntity.ok(updatedStation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
        return ResponseEntity.noContent().build();
    }
}
