package com.example.os.api.service;

import com.example.os.api.common.Payment;
import com.example.os.api.common.TransationRequest;
import com.example.os.api.common.TransationResponse;
import com.example.os.api.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.os.api.repository.OrderRepository;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    public TransationResponse saveOrder(TransationRequest transationRequest){

        String response = "";

        Order order = transationRequest.getOrder();

        Payment payment = transationRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getQty());

        //rest call
        Payment paymentResponse = template.postForObject("http://localhost:9191/payment/doPayment", payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successfull and order placed":"error ocurred";

        repository.save(order);

        return new TransationResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
    }
}
