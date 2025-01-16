package org.example.dronepizzabackend.repositories;

import org.example.dronepizzabackend.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StationRepository extends JpaRepository<Station, Long> {
}

