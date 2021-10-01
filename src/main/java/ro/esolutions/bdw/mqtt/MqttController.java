package ro.esolutions.bdw.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.esolutions.bdw.command.CommandResponse;
import ro.esolutions.bdw.config.KafkaGateway;

import javax.annotation.PostConstruct;

@Service
public class MqttController {

    @Autowired
    private KafkaGateway kafkaGateway;

    @Autowired
    private MqttClient mqttClient;

    @PostConstruct
    public void init() throws MqttException {
        mqttClient.subscribe("/command-response", (topic, msg) -> {
            kafkaGateway.sendCommandResponse(new CommandResponse(msg.toString()));
        });
    }
}
