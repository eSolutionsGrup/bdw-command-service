package ro.esolutions.bdw.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ro.esolutions.bdw.config.KafkaGateway;

@Service
public class CommandRequestHandler {

    @Autowired
    private KafkaGateway kafkaGateway;

    @StreamListener("command")
    public void commandReceived(@Payload Command command) {
        System.out.println("received kafka command: $command");
        kafkaGateway.sendCommandResponse(new CommandResponse(command.uid));
    }
}
