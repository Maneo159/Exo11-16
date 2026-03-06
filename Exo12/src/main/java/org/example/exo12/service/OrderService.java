package org.example.exo12.service;

import org.example.exo12.entity.Order;
import org.example.exo12.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Mono<Order> createOrder(Order order) {
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }

    public Mono<Order> updateOrderStatus(Long id, String status) {
        return orderRepository.findById(id)
                .flatMap(order -> {
                    order.setStatus(status);
                    return orderRepository.save(order);
                });
    }

    public Mono<Void> deleteOrder(Long id) {
        return orderRepository.deleteById(id);
    }

    public Flux<Order> searchByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public Flux<Order> getOrdersByCustomer(String customerName) {
        return orderRepository.findByCustomerName(customerName);
    }

    public Flux<Order> getPagedOrders(int page, int size) {
        int offset = page * size;
        return orderRepository.findPaged(offset, size);
    }
}

