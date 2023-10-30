package br.com.pockafka.adpters.out.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderTopic {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("orderTime")
    private Long orderTime;

    @JsonProperty("orderAddress")
    private String orderAddress;
}
