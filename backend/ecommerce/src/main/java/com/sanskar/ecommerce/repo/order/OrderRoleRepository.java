package com.sanskar.ecommerce.repo.order;

import com.sanskar.ecommerce.entity.order.OrderRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRoleRepository extends JpaRepository<OrderRole, Long> {
}
