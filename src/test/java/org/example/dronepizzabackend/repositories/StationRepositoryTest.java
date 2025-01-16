package org.example.dronepizzabackend.repositories;

import org.example.dronepizzabackend.model.Drone;
import org.example.dronepizzabackend.model.Driftsstatus;
import org.example.dronepizzabackend.model.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional // Sørger for at rulle ændringer tilbage efter hver test
public class StationRepositoryTest {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private DroneRepository droneRepository;

    @Test
    void testStationWithDrones() {
        // Opret Station
        Station station = stationRepository.save(new Station(55.41, 12.34));

        // Opret Droner til stationen
        Drone drone1 = droneRepository.save(new Drone(UUID.randomUUID(), Driftsstatus.I_DRIFT, station));
        Drone drone2 = droneRepository.save(new Drone(UUID.randomUUID(), Driftsstatus.UDE_AF_DRIFT, station));

        // Hent station og verificer
        Station retrievedStation = stationRepository.findById(station.getStationId()).orElseThrow();
        assertEquals(2, retrievedStation.getDroner().size());
    }
}

