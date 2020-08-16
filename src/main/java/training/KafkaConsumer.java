package training;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Profile("consumer")
public class KafkaConsumer {

    @KafkaListener(topics = "topic", groupId = "all")
    public void consume(String message) {
        System.out.printf("[Thread ID = %d] Consumed message: \"%s\"\n", Thread.currentThread().getId(), message);
    }
}
