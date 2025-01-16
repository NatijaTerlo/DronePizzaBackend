package org.example.dronepizzabackend.model;

import jakarta.persistence.*;
import org.example.dronepizzabackend.DTO.DeliveryDTO;

import java.time.LocalDateTime;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT og primærnøgle
    private Long deliveryId;

    private String address; // Leveringsadresse

    private LocalDateTime expectedDelivery; // Forventet leveringstidspunkt
    private LocalDateTime actualDelivery;   // Faktisk leveringstidspunkt (kan være null)

    @ManyToOne(optional = false) // En levering skal have en pizza
    private Pizza pizza;

    @ManyToOne // En levering kan være tildelt en drone
    private Drone drone;

    // Standardkonstruktør (krævet af JPA)
    public Delivery() {
    }

    // Konstruktør med parametre for nem oprettelse
    public Delivery(String address, LocalDateTime expectedDelivery, LocalDateTime actualDelivery, Pizza pizza) {
        this.address = address;
        this.expectedDelivery = expectedDelivery;
        this.actualDelivery = actualDelivery;
        this.pizza = pizza;
    }

    public Delivery(DeliveryDTO deliveryDTO) {

    }

    // Getters og Setters
    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(LocalDateTime expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public LocalDateTime getActualDelivery() {
        return actualDelivery;
    }

    public void setActualDelivery(LocalDateTime actualDelivery) {
        this.actualDelivery = actualDelivery;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", address='" + address + '\'' +
                ", expectedDelivery=" + expectedDelivery +
                ", actualDelivery=" + actualDelivery +
                ", pizza=" + (pizza != null ? pizza.getTitel() : "null") +
                ", drone=" + (drone != null ? drone.getSerialUuid() : "null") +
                '}';
    }

    public void updateFromDTO(DeliveryDTO deliveryDTO) {

    }

}
