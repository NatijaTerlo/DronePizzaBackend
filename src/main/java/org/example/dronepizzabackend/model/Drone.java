package org.example.dronepizzabackend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT og primærnøgle
    private Long droneId;

    @Column(unique = true, nullable = false)
    private UUID serialUuid;

    @Enumerated(EnumType.STRING)
    private Driftsstatus driftsstatus;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false) // Fremmednøgle til Station
    private Station station;

    // Standardkonstruktør
    public Drone() {
    }

    // Konstruktør med parametre
    public Drone(UUID serialUuid, Driftsstatus driftsstatus, Station station) {
        this.serialUuid = serialUuid;
        this.driftsstatus = driftsstatus;
        this.station = station;
    }

    // Getters og Setters
    public Long getDroneId() {
        return droneId;
    }

    public void setDroneId(Long droneId) {
        this.droneId = droneId;
    }

    public UUID getSerialUuid() {
        return serialUuid;
    }

    public void setSerialUuid(UUID serialUuid) {
        this.serialUuid = serialUuid;
    }

    public Driftsstatus getDriftsstatus() {
        return driftsstatus;
    }

    public void setDriftsstatus(Driftsstatus driftsstatus) {
        this.driftsstatus = driftsstatus;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
