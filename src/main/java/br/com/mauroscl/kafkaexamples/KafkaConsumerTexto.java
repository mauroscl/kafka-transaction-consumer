package br.com.mauroscl.kafkaexamples;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerTexto {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private int contador = 0;

  public KafkaConsumerTexto(final KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @KafkaListener(groupId = "consumer-texto", topics = "text-topic", properties = {
      ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG + "=5000"})
  void listen(String texto) throws InterruptedException {
    log.info(texto);

    kafkaTemplate.send("substring-topic", texto);

    if (contador == 1) {
      Thread.sleep(7_000);
      log.info("Dormindo: {}", texto );
      contador = 0;
    } else {
      contador++;
      log.info("Não Dormindo: {}", texto );
    }

  }

}
