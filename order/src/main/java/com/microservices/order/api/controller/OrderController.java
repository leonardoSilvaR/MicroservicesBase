package com.microservices.order.api.controller;

import com.microservices.order.api.request.OrderRequest;
import com.microservices.order.api.response.OrderResponse;
import com.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAccount(@RequestBody OrderRequest orderRequest, UriComponentsBuilder uriComponentsBuilder) {
        URI location = uriComponentsBuilder.path("/orders/{orderId}")
                .buildAndExpand(orderService.createOrder(orderRequest).getOrderId())
                .toUri();
        log.info("[Order Controller] Order Created.");
        return ResponseEntity.created(location)
                .build();
    }

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("orderId") @NonNull UUID orderId) {
        OrderResponse response = orderService.retrieveOrder(orderId);
        log.info("[Order Controller] Order found.");
        return ResponseEntity.ok(response);
    }
}
