package org.example.dronepizzabackend.model;

import jakarta.persistence.*;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id") // Brug entydigt kolonnenavn
    private Long pizzaId;

    private String titel;

    private int pris;

    // Standard constructor
    public Pizza() {
    }

    // Constructor med parametre
    public Pizza(String titel, int pris) {
        this.titel = titel;
        this.pris = pris;
    }

    // Getters og setters
    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
