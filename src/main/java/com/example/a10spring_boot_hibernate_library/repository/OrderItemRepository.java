package com.example.a10spring_boot_hibernate_library.repository;

import com.example.a10spring_boot_hibernate_library.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    // You can add custom query methods here if needed

    List<OrderItem> findByOrderId(Integer orderId);

}

