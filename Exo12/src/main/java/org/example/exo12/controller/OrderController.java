package org.example.exo12.controller;

import org.example.exo12.entity.Order;
import org.example.exo12.service.OrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/search")
    public Flux<Order> searchByStatus(@RequestParam String status) {
        return orderService.searchByStatus(status);
    }

    @GetMapping("/paged")
    public Flux<Order> getPagedOrders(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size) {
        return orderService.getPagedOrders(page, size);
    }

    @GetMapping("/customer/{customerName}")
    public Flux<Order> getOrdersByCustomer(@PathVariable String customerName) {
        return orderService.getOrdersByCustomer(customerName);
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Mono<Order> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}

