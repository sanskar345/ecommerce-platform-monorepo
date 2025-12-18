package com.sanskar.ecommerce.order.service;

import com.sanskar.ecommerce.order.dto.OrderItemRequest;
import com.sanskar.ecommerce.order.dto.OrderRequest;
import com.sanskar.ecommerce.order.entity.Order;
import com.sanskar.ecommerce.order.entity.OrderItem;
import com.sanskar.ecommerce.order.entity.OrderRole;
import com.sanskar.ecommerce.user.entity.User;
import com.sanskar.ecommerce.product.entity.Product;
import com.sanskar.ecommerce.order.repository.OrderItemRepository;
import com.sanskar.ecommerce.order.repository.OrderRepository;
import com.sanskar.ecommerce.order.repository.OrderRoleRepository;
import com.sanskar.ecommerce.user.repository.UserRepository;
import com.sanskar.ecommerce.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRoleRepository orderRoleRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order createOrder(OrderRequest orderRequest) {
        User user = userRepository.findByEmail(orderRequest.email())
                .orElseGet(() -> {
                    User newUser = User.builder()
                            .name(orderRequest.customerName())
                            .email(orderRequest.email())
                            .build();

                    return userRepository.save(newUser);
                });

        Order order = Order.builder()
                .statusId("CREATED")
                .orderDate(LocalDate.now())
                .build();
        order = orderRepository.save(order);

        OrderRole orderRole = OrderRole.builder()
                .user(user)
                .order(order)
                .roleTypeId("CUSTOMER")
                .build();
        orderRole = orderRoleRepository.save(orderRole);

        List<OrderItem> orderItems = new ArrayList<>();

        for (int i=0; i<orderRequest.items().size(); i++) {
            OrderItemRequest orderItemRequest = orderRequest.items().get(i);
            Product product = productRepository.findById(orderItemRequest.productId()).orElseThrow(() -> new IllegalArgumentException(
                    "Product not found: " + orderItemRequest.productId()
            ));

            OrderItem orderItem = OrderItem
                    .builder()
                    .orderItemSeqId(i+1)
                    .product(product)
                    .quantity(orderItemRequest.quantity())
                    .order(order)
                    .build();
            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);

        order.setOrderItems(orderItems);
        order.setOrderRoles(List.of(orderRole));

        return order;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAllOrderWithOrderRolesAndOrderItems();

        System.out.println("=========orders=========" + orders);

        return orders;
    }
}
