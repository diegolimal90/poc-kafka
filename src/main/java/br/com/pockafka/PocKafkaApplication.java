package br.com.pockafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafka
public class PocKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocKafkaApplication.class, args);
    }

}
