package ro.esolutions.bdw.command;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ro.esolutions.bdw.config.KafkaGateway;

@Service
public class CommandRequestHandler {

    @Autowired
    private MqttClient mqttClient;

    @StreamListener("command")
    public void commandReceived(@Payload Command command) throws MqttException {
        System.out.println("received kafka command: $command");
        mqttClient.publish("/command", new MqttMessage(command.uid.getBytes()));
    }
}
