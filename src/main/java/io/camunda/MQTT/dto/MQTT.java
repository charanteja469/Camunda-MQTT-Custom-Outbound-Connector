package io.camunda.MQTT.dto;



import org.eclipse.paho.client.mqttv3.*;

public class MQTT {

    public String messagePublish(String serverURL,
                                 String mqttTopic,
                                 String clientId,
                                 String message) {

        try {
            MqttClient client = new MqttClient(serverURL, clientId);
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            client.connect(options);
            MqttMessage payload = new MqttMessage(message.getBytes());
            payload.setQos(1);
            client.publish(mqttTopic, payload);
            client.disconnect();
            client.close();
        }
        catch (MqttException e) {
            e.printStackTrace();
        }

        return "OK";
    }
}
