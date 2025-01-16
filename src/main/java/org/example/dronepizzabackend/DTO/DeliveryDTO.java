package org.example.dronepizzabackend.DTO;


import org.example.dronepizzabackend.model.Delivery;

import java.time.LocalDateTime;

public class DeliveryDTO {

    private Long id;
    private String address;
    private LocalDateTime expectedDeliveryTime;
    private LocalDateTime actualDeliveryTime;
    private Long pizzaId;
    private Long droneId;


    public DeliveryDTO() {
    }


    public DeliveryDTO(Delivery delivery) {
        this.id = delivery.getDeliveryId();
        this.address = delivery.getAddress();
        this.expectedDeliveryTime = delivery.getExpectedDelivery();
        this.actualDeliveryTime = delivery.getActualDelivery();
        this.pizzaId = delivery.getPizza() != null ? delivery.getPizza().getPizzaId() : null;
        this.droneId = delivery.getDrone() != null ? delivery.getDrone().getDroneId() : null;
    }

    // Getters og setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(LocalDateTime expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public LocalDateTime getActualDeliveryTime() {
        return actualDeliveryTime;
    }

    public void setActualDeliveryTime(LocalDateTime actualDeliveryTime) {
        this.actualDeliveryTime = actualDeliveryTime;
    }

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public Long getDroneId() {
        return droneId;
    }

    public void setDroneId(Long droneId) {
        this.droneId = droneId;
    }
}

