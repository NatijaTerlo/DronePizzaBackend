package org.example.dronepizzabackend.DTO;

import org.example.dronepizzabackend.model.Driftsstatus;

import java.util.UUID;

public class DroneDTO {

    private Long droneId;
    private String serialUuid; // Skal være en gyldig UUID-streng
    private String driftsstatus; // Enum-type: "I_DRIFT", "UDE_AF_DRIFT", "UDFASET"
    private Long stationId;

    // Kun stationens ID for at minimere dataoverførsel


    public DroneDTO(Long droneId, String serialUuid, String driftsstatus, Long stationId) {
        this.droneId = droneId;
        this.serialUuid = serialUuid;
        this.driftsstatus = driftsstatus;
        this.stationId = stationId;
    }

    public DroneDTO() {

    }

    public Long getDroneId() {
        return droneId;
    }

    public void setDroneId(Long droneId) {
        this.droneId = droneId;
    }

    public String getSerialUuid() {
        return serialUuid;
    }

    public void setSerialUuid(String serialUuid) {
        this.serialUuid = serialUuid;
    }

    public String getDriftsstatus() {
        return driftsstatus;
    }

    public void setDriftsstatus(String driftsstatus) {
        this.driftsstatus = driftsstatus;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }
}

