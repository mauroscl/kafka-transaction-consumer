package br.com.mauroscl.kafkaexamples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaTransactionConsumerApplication implements CommandLineRunner {

  @Autowired
  private KafkaProducer kafkaProducer;

  public static void main(String[] args) {
    SpringApplication.run(KafkaTransactionConsumerApplication.class, args);
  }

  @Override
  public void run(final String... args) throws Exception {
    kafkaProducer.produce();
  }
}
