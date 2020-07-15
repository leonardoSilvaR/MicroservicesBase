package com.microservices.order.api.response;

import com.microservices.order.model.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderResponse {

    private UUID orderId;
    private OrderStatus status;
}
