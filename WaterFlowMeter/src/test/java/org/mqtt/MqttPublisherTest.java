package org.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MqttPublisherTest {
    MqttPublisher publisher = new MqttPublisher("random", "random", new ArrayList<>());
    @Test
    public void publishTest() throws MqttException, InterruptedException {
        publisher.publish();
    }
}