package ro.esolutions.bdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import ro.esolutions.bdw.config.KafkaGateway;

@SpringBootApplication
@EnableBinding(KafkaGateway.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
