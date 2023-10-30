package br.com.pockafka.ports;

import br.com.pockafka.domain.Order;
import org.apache.commons.lang3.NotImplementedException;

public interface SaveOrderPort {

    default void save(Order order){
        throw new NotImplementedException("method not implemented");
    }
}
