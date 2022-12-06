package org.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.Test;


import java.io.IOException;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertTrue;


class MqttPublisherTest {
    MqttPublisher publisher = new MqttPublisher();

    @Test
    public void serializeMessageTest(){
        ObjectMapper mapper = new ObjectMapper();


    }
}