package com.sanskar.ecommerce.order.controller;

import com.sanskar.ecommerce.order.dto.OrderRequest;
import com.sanskar.ecommerce.order.dto.OrderResponse;
import com.sanskar.ecommerce.order.entity.Order;
import com.sanskar.ecommerce.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> postOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        List<OrderResponse> orderResponses = new ArrayList<>();
        return ResponseEntity.ok(orderResponses);
    }
}
