package org.example.dronepizzabackend.impl;

import org.example.dronepizzabackend.DTO.StationDTO;
import org.example.dronepizzabackend.model.Station;
import org.example.dronepizzabackend.repositories.StationRepository;
import org.example.dronepizzabackend.service.StationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public List<StationDTO> getAllStations() {
        return stationRepository.findAll().stream()
                .map(station -> new StationDTO(station.getStationId(), station.getLatitude(), station.getLongitude()))
                .collect(Collectors.toList());
    }

    @Override
    public StationDTO getStationById(Long id) {
        Station station = stationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found with ID: " + id));
        return new StationDTO(station.getStationId(), station.getLatitude(), station.getLongitude());
    }

    @Override
    public StationDTO createStation(StationDTO stationDTO) {
        Station station = new Station(stationDTO.getLatitude(), stationDTO.getLongitude());
        Station savedStation = stationRepository.save(station);
        return new StationDTO(savedStation.getStationId(), savedStation.getLatitude(), savedStation.getLongitude());
    }

    @Override
    public StationDTO updateStation(Long id, StationDTO stationDTO) {
        Station station = stationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Station not found with ID: " + id));
        station.setLatitude(stationDTO.getLatitude());
        station.setLongitude(stationDTO.getLongitude());
        Station updatedStation = stationRepository.save(station);
        return new StationDTO(updatedStation.getStationId(), updatedStation.getLatitude(), updatedStation.getLongitude());
    }

    @Override
    public void deleteStation(Long id) {
        if (!stationRepository.existsById(id)) {
            throw new RuntimeException("Station not found with ID: " + id);
        }
        stationRepository.deleteById(id);
    }
}

