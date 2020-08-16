package training;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaAdminConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("topic").partitions(1).replicas(1).build();
    }
}
