package org.example.dronepizzabackend.config;

import org.example.dronepizzabackend.model.*;
import org.example.dronepizzabackend.repositories.DeliveryRepository;
import org.example.dronepizzabackend.repositories.DroneRepository;
import org.example.dronepizzabackend.repositories.PizzaRepository;
import org.example.dronepizzabackend.repositories.StationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StationRepository stationRepository;

    public DataInitializer(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public void run(String... args) {
        // Seed Stationer (Kun her for at undgå dubletter)
        stationRepository.save(new Station(55.41, 12.34));
        stationRepository.save(new Station(55.42, 12.35));
        stationRepository.save(new Station(55.43, 12.36));
    }

    @Bean
    public CommandLineRunner seedData(PizzaRepository pizzaRepository, StationRepository stationRepository, DroneRepository droneRepository, DeliveryRepository deliveryRepository) {
        return args -> {
            pizzaRepository.save(new Pizza("Margherita", 70));
            pizzaRepository.save(new Pizza("Pepperoni", 80));


            // Seed Stationer
            Station station1 = stationRepository.findById(1L).orElse(null);
            Station station2 = stationRepository.findById(2L).orElse(null);
            Station station3 = stationRepository.findById(3L).orElse(null);

            // Seed Droner
            droneRepository.save(new Drone(UUID.randomUUID(), Driftsstatus.I_DRIFT, station1));
            droneRepository.save(new Drone(UUID.randomUUID(), Driftsstatus.UDE_AF_DRIFT, station2));
            droneRepository.save(new Drone(UUID.randomUUID(), Driftsstatus.I_DRIFT, station3));

            Pizza pizza1 = pizzaRepository.findById(1L).orElseThrow(() -> new RuntimeException("Pizza not found"));
            Pizza pizza2 = pizzaRepository.findById(2L).orElseThrow(() -> new RuntimeException("Pizza not found"));

            Delivery levering1 = new Delivery("Amagerbrogade 20", LocalDateTime.now().plusMinutes(30), null, pizza1);
            Delivery levering2 = new Delivery("Østerbrogade 50", LocalDateTime.now().plusMinutes(45), null, pizza2);

// Gem leveringer i repository
            deliveryRepository.save(levering1);
            deliveryRepository.save(levering2);

        };
    }
}
