package training;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Profile("producer")
@Configuration
public class KafkaAdminConfig {

    @Bean
    public NewTopic topicB() {
        return TopicBuilder.name("topicB").partitions(1).replicas(1).build();
    }
}
