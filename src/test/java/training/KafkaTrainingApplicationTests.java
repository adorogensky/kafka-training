package training;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootTest
class KafkaTrainingApplicationTests {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Test
	void sendMessage() {
		System.out.println("(test) Heap size: " + Runtime.getRuntime().totalMemory()/1024/1024 + "MB");
		System.out.println("(test) Heap max size: " + Runtime.getRuntime().maxMemory()/1024/1024 + "MB");
		System.out.println("(test) Heap free size: " + Runtime.getRuntime().freeMemory()/1024/1024 + "MB");
		kafkaTemplate.send("topic", "inbound message " + LocalDateTime.now());
	}

}
