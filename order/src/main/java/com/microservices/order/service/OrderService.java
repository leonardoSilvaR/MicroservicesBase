package com.microservices.order.service;

import com.microservices.order.api.request.OrderRequest;
import com.microservices.order.api.response.OrderResponse;
import com.microservices.order.integration.account.AccountIntegration;
import com.microservices.order.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final AccountIntegration accountIntegration;

    public OrderResponse createOrder(@NonNull OrderRequest orderRequest) {
        accountIntegration.retrieveAccount(orderRequest.getAccountId());

        log.info("[Order Service] Order created.");
        return OrderResponse.builder()
                .orderId(UUID.fromString("ad75949a-c560-11ea-87d0-0242ac130003"))
                .status(OrderStatus.CREATED)
                .build();
    }

    public OrderResponse retrieveOrder(@NonNull UUID orderId) {
        return OrderResponse.builder()
                .orderId(UUID.fromString("ad75949a-c560-11ea-87d0-0242ac130003"))
                .status(OrderStatus.CREATED)

                .build();
    }
}
