package org.mqtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.IOException;
import java.util.List;

public class MqttPublisher {
    private String url;
    private String topic;
    private List<Sensor> sensors;

    MqttPublisher() {
    }

    /*private void createMessage(){
        sensors.add(new Sensor("Trenutna temperatura vode", 10, -32668, 32668, "C"));
        sensors.add(new Sensor("Trenutni tlak vode", 1000, 0, 65336, "Bar"));
        sensors.add(new Sensor("Potrosnja u zadnjih 1 min, 10 min, 1 sat, 1 dan", 0, 0, 65336, "litra"));
        sensors.add(new Sensor("Potrosnja u zadnjih 1 tjedan, 1 mjesec, 1 godinu", 10, 0, 65336, "m3"));
    }*/

    public String serializeMessage(Sensor sensor) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(sensor);
    }

    public void publish() throws MqttException, InterruptedException, IOException {
        MqttClient client = new MqttClient(url, MqttClient.generateClientId());

        MqttMessage message = new MqttMessage();

        //while(true) {
            client.connect();
            //createMessage();

            for (Sensor sensor:sensors){
                String temp = serializeMessage(sensor);
                message.setPayload(temp.getBytes());
                client.publish(topic, message);
                Thread.sleep(1000L);
            }
            client.disconnect();
        //}
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }



}
