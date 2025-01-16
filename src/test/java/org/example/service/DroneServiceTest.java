package org.example.service;

import org.example.dronepizzabackend.service.DroneService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DroneServiceTest {
    @Autowired
    private DroneService droneService;

    @Test
    public void testAddDrone() {

        assertNotNull(droneService);
    }
}
