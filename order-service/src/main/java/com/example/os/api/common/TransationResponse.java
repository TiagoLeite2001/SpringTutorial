package com.example.os.api.common;

import com.example.os.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransationResponse {

    private Order order;
    private String transactionId;
    private double amount;
    private String message;
}
