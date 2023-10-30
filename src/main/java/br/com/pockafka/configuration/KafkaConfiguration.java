package br.com.pockafka.configuration;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConfiguration {

//    @Value("${java.security.auth.login.config}")
//    private String authConfig;  // path to you jaas-client-$profile.conf

    @Value("${spring.kafka.properties.sasl.jaas.config}")
    private String jaasConfig;
    /**
     * This implementation configures the run time environment with the relevant
     * Kerberos security properties.
     */
    @PostConstruct
    public void setProperty() {
//        System.setProperty("java.security.krb5.conf", krb5Conf);
        System.setProperty("java.security.auth.login.config", jaasConfig);
    }

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(
                Map.of(BOOTSTRAP_SERVERS_CONFIG, "pkc-4v5zz.sa-east-1.aws.confluent.cloud:9092",
                        RETRIES_CONFIG, 0,
                        BUFFER_MEMORY_CONFIG, 33554432,
                        "security.protocol", "SASL_SSL",

                        KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                        VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
                )
        );
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
