package org.mqtt;


import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws MqttException, InterruptedException {
        MqttPublisher publisher = new MqttPublisher("tcp://localhost:1883", "iot_data", new ArrayList<>());
        publisher.publish();
    }
}

//mosquitto_sub -h 127.0.0.1 -t iot_data