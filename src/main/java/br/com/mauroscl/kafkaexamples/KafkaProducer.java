package br.com.mauroscl.kafkaexamples;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
class KafkaProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  KafkaProducer(final KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void produce() {

    kafkaTemplate.send("text-topic", "ana");
    kafkaTemplate.send("text-topic", "flavia");
  }


}
