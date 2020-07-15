package com.microservices.order.api.request;


import com.microservices.order.model.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderRequest {

    private UUID accountId;
    private UUID productId;
    private int quantity;
    private PaymentMethod paymentMethod;

}
