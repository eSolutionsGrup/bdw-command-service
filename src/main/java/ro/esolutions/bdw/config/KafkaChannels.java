package ro.esolutions.bdw.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaChannels {

    @Output
    MessageChannel commandResponse();

    @Input
    MessageChannel command();
}
