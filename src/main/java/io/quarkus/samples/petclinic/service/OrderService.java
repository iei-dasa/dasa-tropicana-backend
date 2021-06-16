package io.quarkus.samples.petclinic.service;
import io.quarkus.samples.petclinic.service.Interface.IOrderService;
import io.quarkus.samples.petclinic.model.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;



@ApplicationScoped
@Transactional
public class OrderService {

    public Order saveOrder(Order order) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
