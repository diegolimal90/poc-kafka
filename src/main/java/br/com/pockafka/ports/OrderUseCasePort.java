package br.com.pockafka.ports;

import br.com.pockafka.domain.Order;
import org.apache.commons.lang3.NotImplementedException;

public interface OrderUseCasePort {
    default void executeSave(Order order){
        throw new NotImplementedException("Metodo não implementado.");
    };
}
