package com.cdc.dcop.services;

import com.cdc.dcop.entity.Order;
import com.cdc.dcop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public boolean deleteById(Long orderId) {
        boolean deleted = false;
        Order entity = orderRepository.findById(orderId).orElse(null);
        if (entity != null) {
            entity.setActive(false);
            orderRepository.save(entity);
            deleted = true;
        }
        return deleted;
    }
}
