package com.cdc.dcop.services;

import com.cdc.dcop.dto.OrderDTO;
import com.cdc.dcop.entity.Order;
import com.cdc.dcop.enums.PetStatusEnum;
import com.cdc.dcop.entity.Pet;
import com.cdc.dcop.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    IPetstoreService petstoreService;

    @Autowired
    ModelMapper mapper;

    public boolean deleteById(Long orderId) {
        boolean deleted = false;
        Order entity = orderRepository.findById(orderId).orElse(null);
        if (entity != null) {
            orderRepository.save(entity);
            deleted = true;
        }
        return deleted;
    }

    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Pet pet = petstoreService.findById(orderDTO.getPetId());
        if (pet != null && pet.getStatus().equals(PetStatusEnum.AVAILABLE.getName())) {
            pet.setStatus(PetStatusEnum.SOLD.getName());
            petstoreService.update(pet, pet.getId());
            Order order = orderRepository.save(mapOrderDtoToEntity(orderDTO, pet));
            return mapOrderToDto(order);
        } else {
            return null;
        }
    }

    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        return mapOrderToDto(order);
    }

    private Order mapOrderDtoToEntity(OrderDTO orderDTO, Pet pet) {
        if (orderDTO == null) {
            return null;
        }
        Order order = mapper.map(orderDTO, Order.class);
        order.setPet(pet);
        return order;
    }

    private OrderDTO mapOrderToDto(Order order) {
        return (order != null) ? mapper.map(order, OrderDTO.class): null;
    }
}
