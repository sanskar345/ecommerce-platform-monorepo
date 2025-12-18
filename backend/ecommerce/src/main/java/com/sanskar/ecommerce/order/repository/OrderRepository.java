package com.sanskar.ecommerce.order.repository;

import com.sanskar.ecommerce.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
        SELECT o FROM Order o
        JOIN FETCH o.orderItems
        JOIN FETCH o.orderRoles
    """)
    List<Order> findAllOrderWithOrderRolesAndOrderItems();
}
