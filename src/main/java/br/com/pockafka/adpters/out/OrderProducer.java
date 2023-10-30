package br.com.pockafka.adpters.out;

import br.com.pockafka.adpters.out.entities.OrderTopic;
import br.com.pockafka.domain.Order;
import br.com.pockafka.ports.SaveOrderPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer implements SaveOrderPort {

    private final KafkaTemplate<String, String> template;
    private final ObjectMapper objectMapper;

    @Value("${kafka.topic.order}")
    private String kafkaTopic;

    public void save(Order order){
        try {
            send(objectMapper.writeValueAsString(Order.to(order)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
    private void send(String message){
        //fake not need here project
        //flux not need in project
        template.send(kafkaTopic, message);
    }
}
