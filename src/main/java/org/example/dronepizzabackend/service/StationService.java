package org.example.dronepizzabackend.service;

import org.example.dronepizzabackend.DTO.StationDTO;

import java.util.List;

public interface StationService {
    List<StationDTO> getAllStations();
    StationDTO getStationById(Long id);
    StationDTO createStation(StationDTO stationDTO);
    StationDTO updateStation(Long id, StationDTO stationDTO);
    void deleteStation(Long id);
}
