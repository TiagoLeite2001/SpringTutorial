package com.example.os.api.controller;

import com.example.os.api.common.Payment;
import com.example.os.api.common.TransationRequest;
import com.example.os.api.common.TransationResponse;
import com.example.os.api.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.os.api.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bookOrder")
    public TransationResponse bookOrder(@RequestBody TransationRequest request){

        return service.saveOrder(request);
    }
}
