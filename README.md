# kafka-training

## [Docker Apache Kafka on Confluence Platform](https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html#ce-docker-quickstart)
```
git clone https://github.com/confluentinc/cp-all-in-one
cd cp-all-in-one
git checkout 5.5.1-post
cd cp-all-in-one
docker-compose up -d
```

## KafkaTrainingApplication
### Build
```
./gradlew clean build
```
### Run
```
SPRING_PROFILES_ACTIVE=producer java -jar build/libs/kafka-training-0.0.1-SNAPSHOT.jar
```
   * the kafka producer will send a message to "topicA"
   * the kafka admin will create a topic "topicB"
```   
SPRING_PROFILES_ACTIVE=consumer java -jar build/libs/kafka-training-0.0.1-SNAPSHOT.jar
```
   * the kafka consumer will listen to messages on "topicA" and consumer group "group1"

## Issues
   * [Incorrect "bootstrap.servers" in KafkaProducerConfig prints "java.lang.OutOfMemoryError: Java heap space" exception](https://htmlpreview.github.io/?https://github.com/adorogensky/kafka-training/blob/master/errors/kafka-producer-heap-space/classes/training.KafkaTrainingApplicationTests.html#sendMessage())
   
## Questions
   * @KafkaListner topic gets created when the listener is intialized?
   * KafkaTemplate topic gets created when a message is sent
  
