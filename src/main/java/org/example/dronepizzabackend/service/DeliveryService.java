package org.example.dronepizzabackend.service;

import org.example.dronepizzabackend.DTO.DeliveryDTO;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDTO> getAllDeliveries();
    DeliveryDTO getDeliveryById(Long id);
    DeliveryDTO createDelivery(DeliveryDTO deliveryDTO);
    DeliveryDTO updateDelivery(Long id, DeliveryDTO deliveryDTO);
    void deleteDelivery(Long id);
}
