package br.com.mauroscl.kafkaexamples;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerSubstring {

  @KafkaListener(groupId = "consumer-substring", topics = "substring-topic",
      properties = {ConsumerConfig.ISOLATION_LEVEL_CONFIG + "=read_committed"}
  )
  void handle(@Payload String parte) {
    log.info(parte);
  }

}
