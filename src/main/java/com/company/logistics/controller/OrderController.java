package com.company.logistics.controller;

import com.company.logistics.controller.dto.order.*;
import com.company.logistics.service.OrderService;
import com.company.logistics.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final ProfitService profitService;
    //private final ProfitService profitService

    @Autowired
    public OrderController(OrderService orderService, ProfitService profitService) {
        this.orderService = orderService;
        this.profitService = profitService;
    }
    @GetMapping("/order/count")
    public Map<String, Integer> countOrdersByToken(@RequestParam("token") String token) {

        return orderService.countOrdersByToken(token);
    }
    @GetMapping("/order/count/7day")
    public Map<String, Object> countOrdersPastSevenDays(@RequestParam("token") String token) {

        return orderService.countOrdersPastSevenDays(token);
    }
    @GetMapping("/order/list")
    public GetOrderResponse getOrders(@RequestParam("offset") int offset,
                                       @RequestParam("pageSize") int pageSize,
                                       @RequestParam("token") String token) {

        return orderService.getOrders(token, offset, pageSize);
    }
    @GetMapping("/order/{id}")
    public Map<String, Object> getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }
    @PostMapping("/order/add")
    public int addOrder(@RequestBody SetOrderRequest setOrderRequest) {
        //profitService.addProfit(setOrderRequest, randomUUIDString);

        return orderService.addOrder(setOrderRequest);
    }
    @PostMapping("/order/taking")
    public int takingOrder(@RequestBody TakingOrderRequest takingOrderRequest) {
        return orderService.takingOrder(takingOrderRequest);
    }

    @PostMapping("/order/sign")
    public int signOrder(@RequestBody SignOrderRequest signOrderRequest) {
        return orderService.signOrder(signOrderRequest);
    }

    @PostMapping("/order/refuse")
    public int refuseOrder(@RequestBody RefuseOrderRequest refuseOrderRequest) {
        return orderService.refuseOrder(refuseOrderRequest);
    }
}
