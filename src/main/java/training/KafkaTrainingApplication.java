package training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableKafka
public class KafkaTrainingApplication implements CommandLineRunner {

	private final ApplicationContext applicationContext;
	private final Environment environment;

	private static final String USAGE_MSG = "Use SPRING_PROFILES_ACTIVE=[producer|consumer] env variable";

	KafkaTrainingApplication(ApplicationContext applicationContext, Environment environment) {
		this.applicationContext = applicationContext;
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaTrainingApplication.class, args);
	}

	@Override
	public synchronized void run(String... args) {
		if (isProducer()) {
			applicationContext.getBean(KafkaProducer.class).produce("inbound message " + LocalDateTime.now());
		} else if (isConsumer()) {
			try {
				System.out.printf("[Thread ID = %d] Putting main thread to sleep ...\n", Thread.currentThread().getId());
				this.wait();
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		} else {
			throw new IllegalArgumentException(USAGE_MSG);
		}
	}

	private boolean isProducer() {
		return springActiveProfilesEquals("producer");
	}

	private boolean isConsumer() {
		return springActiveProfilesEquals("consumer");
	}

	private boolean springActiveProfilesEquals(String activeProfile) {
		return environment.getActiveProfiles().length == 1 && activeProfile.equals(environment.getActiveProfiles()[0]);
	}
}
