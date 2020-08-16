package training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaTrainingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTrainingApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Starting KafkaTrainingApplication ...");
		System.out.println("(main) Heap size: " + Runtime.getRuntime().totalMemory()/1024/1024 + "MB");
		System.out.println("(main) Heap max size: " + Runtime.getRuntime().maxMemory()/1024/1024 + "MB");
		System.out.println("(main) Heap free size: " + Runtime.getRuntime().freeMemory()/1024/1024 + "MB");

	}
}
