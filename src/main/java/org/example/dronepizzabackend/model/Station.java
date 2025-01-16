package org.example.dronepizzabackend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT og primærnøgle
    private Long stationId;

    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL) // Invers side af relationen
    private List<Drone> droner;

    public Station(double v, double v1) {

    }

    public Station() {

    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Drone> getDroner() {
        return droner;
    }

    public void setDroner(List<Drone> droner) {
        this.droner = droner;
    }

}
