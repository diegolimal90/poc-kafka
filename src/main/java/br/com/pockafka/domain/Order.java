package br.com.pockafka.domain;

import br.com.pockafka.adpters.out.entities.OrderTopic;
import br.com.pockafka.openapi.model.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Long time;
    private String address;

    public static OrderTopic to(Order order){
        return Optional.ofNullable(order).map(source -> OrderTopic.builder()
                .id(source.getId())
                .orderTime(source.getTime())
                .orderAddress(source.getAddress())
                .build()
        ).orElse(new OrderTopic());
    }

    public static Order from(OrderRequest order){
        return Optional.ofNullable(order).map(source -> Order.builder()
                .id(source.getId())
                .time(source.getOrderTime())
                .address(source.getOrderAddress())
                .build()
        ).orElse(new Order());
    }
}
