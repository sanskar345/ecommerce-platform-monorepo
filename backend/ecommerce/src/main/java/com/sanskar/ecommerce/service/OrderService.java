package com.sanskar.ecommerce.service;

import com.sanskar.ecommerce.dto.order.OrderItemRequest;
import com.sanskar.ecommerce.dto.order.OrderItemResponse;
import com.sanskar.ecommerce.dto.order.OrderRequest;
import com.sanskar.ecommerce.dto.order.OrderResponse;
import com.sanskar.ecommerce.entity.order.Order;
import com.sanskar.ecommerce.entity.order.OrderItem;
import com.sanskar.ecommerce.entity.order.OrderRole;
import com.sanskar.ecommerce.entity.party.Party;
import com.sanskar.ecommerce.entity.product.Product;
import com.sanskar.ecommerce.repo.order.OrderItemRepository;
import com.sanskar.ecommerce.repo.order.OrderRepository;
import com.sanskar.ecommerce.repo.order.OrderRoleRepository;
import com.sanskar.ecommerce.repo.party.PartyRepository;
import com.sanskar.ecommerce.repo.product.ProductRepository;
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
    private final PartyRepository partyRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Order craeteOrder(OrderRequest orderRequest) {
        Party party = partyRepository.findByEmail(orderRequest.email())
                .orElseGet(() -> {
                    Party newParty = Party.builder()
                            .name(orderRequest.customerName())
                            .email(orderRequest.email())
                            .build();

                    return partyRepository.save(newParty);
                });

        Order order = Order.builder()
                .statusId("CREATED")
                .orderDate(LocalDate.now())
                .build();
        order = orderRepository.save(order);

        OrderRole orderRole = OrderRole.builder()
                .party(party)
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

    public OrderResponse toResponse(Order order) {
        Party party = order.getOrderRoles().stream()
                .filter(role -> role.getRoleTypeId().equals("CUSTOMER"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No customer found with this order"));

        List<OrderItemResponse> orderItems = order.getOrderItems().stream()
                .map(item -> {
                    Product product =
                    new OrderItemResponse(item.getId())
                })

        return new OrderResponse(
                order.getId(),
                party.getName(),
                party.getEmail(),
                order.getStatusId(),
                order.getOrderDate(),
                order.getOrderItems()
        );
    }
}
