package org.example.dronepizzabackend.impl;

import org.example.dronepizzabackend.DTO.DeliveryDTO;
import org.example.dronepizzabackend.model.Delivery;
import org.example.dronepizzabackend.model.Drone;
import org.example.dronepizzabackend.model.Pizza;
import org.example.dronepizzabackend.repositories.DeliveryRepository;
import org.example.dronepizzabackend.repositories.DroneRepository;
import org.example.dronepizzabackend.repositories.PizzaRepository;
import org.example.dronepizzabackend.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final PizzaRepository pizzaRepository;
    private final DroneRepository droneRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, PizzaRepository pizzaRepository, DroneRepository droneRepository) {
        this.deliveryRepository = deliveryRepository;
        this.pizzaRepository = pizzaRepository;
        this.droneRepository = droneRepository;
    }

    @Override
    public List<DeliveryDTO> getAllDeliveries() {
        return deliveryRepository.findAll()
                .stream()
                .map(DeliveryDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDTO getDeliveryById(Long id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found with ID: " + id));
        return new DeliveryDTO(delivery);
    }

    @Override
    public DeliveryDTO createDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();
        delivery.setAddress(deliveryDTO.getAddress());
        delivery.setExpectedDelivery(deliveryDTO.getExpectedDeliveryTime());
        delivery.setActualDelivery(deliveryDTO.getActualDeliveryTime());

        Pizza pizza = pizzaRepository.findById(deliveryDTO.getPizzaId())
                .orElseThrow(() -> new RuntimeException("Pizza not found with ID: " + deliveryDTO.getPizzaId()));
        delivery.setPizza(pizza);

        if (deliveryDTO.getDroneId() != null) {
            Drone drone = droneRepository.findById(deliveryDTO.getDroneId())
                    .orElseThrow(() -> new RuntimeException("Drone not found with ID: " + deliveryDTO.getDroneId()));
            delivery.setDrone(drone);
        }

        Delivery savedDelivery = deliveryRepository.save(delivery);
        return new DeliveryDTO(savedDelivery);
    }

    @Override
    public DeliveryDTO updateDelivery(Long id, DeliveryDTO deliveryDTO) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found with ID: " + id));

        delivery.setAddress(deliveryDTO.getAddress());
        delivery.setExpectedDelivery(deliveryDTO.getExpectedDeliveryTime());
        delivery.setActualDelivery(deliveryDTO.getActualDeliveryTime());

        if (deliveryDTO.getPizzaId() != null) {
            Pizza pizza = pizzaRepository.findById(deliveryDTO.getPizzaId())
                    .orElseThrow(() -> new RuntimeException("Pizza not found with ID: " + deliveryDTO.getPizzaId()));
            delivery.setPizza(pizza);
        }

        if (deliveryDTO.getDroneId() != null) {
            Drone drone = droneRepository.findById(deliveryDTO.getDroneId())
                    .orElseThrow(() -> new RuntimeException("Drone not found with ID: " + deliveryDTO.getDroneId()));
            delivery.setDrone(drone);
        }

        Delivery updatedDelivery = deliveryRepository.save(delivery);
        return new DeliveryDTO(updatedDelivery);
    }

    @Override
    public void deleteDelivery(Long id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found with ID: " + id));
        deliveryRepository.delete(delivery);
    }
}
