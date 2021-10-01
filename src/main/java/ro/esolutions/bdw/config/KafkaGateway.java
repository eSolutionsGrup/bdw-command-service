package ro.esolutions.bdw.config;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ro.esolutions.bdw.command.CommandResponse;

@MessagingGateway
public interface KafkaGateway {

    @Gateway(requestChannel = "commandResponse")
    void sendCommandResponse(CommandResponse hwid);
}
