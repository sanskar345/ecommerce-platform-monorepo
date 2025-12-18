package com.sanskar.ecommerce.order.repository;

import com.sanskar.ecommerce.order.entity.OrderRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRoleRepository extends JpaRepository<OrderRole, Long> {
}
