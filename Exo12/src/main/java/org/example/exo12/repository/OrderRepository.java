package org.example.exo12.repository;

import org.example.exo12.entity.Order;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OrderRepository extends R2dbcRepository<Order, Long> {

    Flux<Order> findByStatus(String status);

    Flux<Order> findByCustomerName(String customerName);

    @Query("SELECT * FROM orders ORDER BY id LIMIT :size OFFSET :offset")
    Flux<Order> findPaged(int offset, int size);
}

