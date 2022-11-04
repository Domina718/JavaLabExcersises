package org.mqtt;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {
    @Test
    public void sensorTest(){
        Sensor sensor = new Sensor("ime",1,1,100, "jedinica");
        assertTrue(sensor.getValue() >= 1 && sensor.getValue() <= 100);
    }

}