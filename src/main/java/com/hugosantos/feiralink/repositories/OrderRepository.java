package com.hugosantos.feiralink.repositories;

import com.hugosantos.feiralink.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
