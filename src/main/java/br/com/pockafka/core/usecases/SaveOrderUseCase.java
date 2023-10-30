package br.com.pockafka.core.usecases;

import br.com.pockafka.domain.Order;
import br.com.pockafka.ports.OrderUseCasePort;
import br.com.pockafka.ports.SaveOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveOrderUseCase implements OrderUseCasePort {

    private final SaveOrderPort saveOrderPort;

    public void executeSave(Order order){
        saveOrderPort.save(order);
    }
}
