package org.example.dronepizzabackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.dronepizzabackend.DTO.DroneDTO;
import org.example.dronepizzabackend.model.Driftsstatus;
import org.example.dronepizzabackend.model.Drone;
import org.example.dronepizzabackend.repositories.DroneRepository;
import org.example.dronepizzabackend.repositories.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DroneService {

    private final DroneRepository droneRepository;
    private final StationRepository stationRepository;

    public DroneService(DroneRepository droneRepository, StationRepository stationRepository) {
        this.droneRepository = droneRepository;
        this.stationRepository = stationRepository;
    }

    public List<DroneDTO> getAllDrones() {
        return droneRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public DroneDTO getDroneById(Long id) {
        return droneRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Drone not found with ID: " + id));
    }

    public DroneDTO createDrone(DroneDTO droneDTO) {
        Drone drone = new Drone();
        drone.setSerialUuid(UUID.fromString(droneDTO.getSerialUuid()));
        drone.setDriftsstatus(Driftsstatus.valueOf(droneDTO.getDriftsstatus()));
        drone.setStation(stationRepository.findById(droneDTO.getStationId())
                .orElseThrow(() -> new EntityNotFoundException("Station not found with ID: " + droneDTO.getStationId())));
        Drone savedDrone = droneRepository.save(drone);
        return toDTO(savedDrone);
    }

    public DroneDTO updateDrone(Long id, DroneDTO droneDTO) {
        Drone drone = droneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Drone not found with ID: " + id));
        drone.setSerialUuid(UUID.fromString(droneDTO.getSerialUuid()));
        drone.setDriftsstatus(Driftsstatus.valueOf(droneDTO.getDriftsstatus()));
        drone.setStation(stationRepository.findById(droneDTO.getStationId())
                .orElseThrow(() -> new EntityNotFoundException("Station not found with ID: " + droneDTO.getStationId())));
        Drone updatedDrone = droneRepository.save(drone);
        return toDTO(updatedDrone);
    }

    public void deleteDrone(Long id) {
        if (!droneRepository.existsById(id)) {
            throw new EntityNotFoundException("Drone not found with ID: " + id);
        }
        droneRepository.deleteById(id);
    }

    private DroneDTO toDTO(Drone drone) {
        DroneDTO dto = new DroneDTO();
        dto.setDroneId(drone.getDroneId());
        dto.setSerialUuid(String.valueOf(UUID.fromString(drone.getSerialUuid().toString())));
        dto.setDriftsstatus(String.valueOf(Driftsstatus.valueOf(drone.getDriftsstatus().name())));
        dto.setStationId(drone.getStation().getStationId());
        return dto;
    }
}
