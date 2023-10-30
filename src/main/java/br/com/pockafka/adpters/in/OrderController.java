package br.com.pockafka.adpters.in;

import br.com.pockafka.core.usecases.SaveOrderUseCase;
import br.com.pockafka.domain.Order;
import br.com.pockafka.openapi.api.OrderApi;
import br.com.pockafka.openapi.model.OrderRequest;
import br.com.pockafka.ports.OrderUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.net.URI;

@Controller
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderUseCasePort saveOrderUseCase;

    public ResponseEntity<Void> saveOrder(OrderRequest orderRequest){
        saveOrderUseCase.executeSave(Order.from(orderRequest));
        return ResponseEntity.created(URI.create("")).build();
    }

}
