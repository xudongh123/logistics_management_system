package com.company.logistics.controller;

import com.company.logistics.controller.dto.order.*;
import com.company.logistics.service.OrderService;
import com.company.logistics.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OrderController {
    private final OrderService orderService; // 订单服务
    private final ProfitService profitService; // 利润服务

    @Autowired
    public OrderController(OrderService orderService, ProfitService profitService) {
        this.orderService = orderService;
        this.profitService = profitService;
    }

    /**
     * 根据用户令牌统计订单数量
     *
     * @param token 用户令牌
     * @return 包含订单数量的Map
     */
    @GetMapping("/order/count")
    public Map<String, Integer> countOrdersByToken(@RequestParam("token") String token) {
        return orderService.countOrdersByToken(token);
    }

    /**
     * 统计过去七天的订单数量
     *
     * @param token 用户令牌
     * @return 包含过去七天订单数量的Map
     */
    @GetMapping("/order/count/7day")
    public Map<String, Object> countOrdersPastSevenDays(@RequestParam("token") String token) {
        return orderService.countOrdersPastSevenDays(token);
    }

    /**
     * 获取订单列表
     *
     * @param offset 数据偏移量
     * @param pageSize 每页数据数量
     * @param token 用户令牌
     * @return 订单列表响应对象
     */
    @GetMapping("/order/list")
    public GetOrderResponse getOrders(@RequestParam("offset") int offset,
                                      @RequestParam("pageSize") int pageSize,
                                      @RequestParam("token") String token) {
        return orderService.getOrders(token, offset, pageSize);
    }

    /**
     * 根据订单ID获取订单信息
     *
     * @param id 订单ID
     * @return 包含订单信息的Map
     */
    @GetMapping("/order/{id}")
    public Map<String, Object> getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }

    /**
     * 添加订单
     *
     * @param setOrderRequest 添加订单请求对象
     * @return 添加订单的结果
     */
    @PostMapping("/order/add")
    public int addOrder(@RequestBody SetOrderRequest setOrderRequest) {
        //profitService.addProfit(setOrderRequest, randomUUIDString);
        return orderService.addOrder(setOrderRequest);
    }

    /**
     * 接受订单
     *
     * @param takingOrderRequest 接受订单请求对象
     * @return 接受订单的结果
     */
    @PostMapping("/order/taking")
    public int takingOrder(@RequestBody TakingOrderRequest takingOrderRequest) {
        return orderService.takingOrder(takingOrderRequest);
    }

    /**
     * 签收订单
     *
     * @param signOrderRequest 签收订单请求对象
     * @return 签收订单的结果
     */
    @PostMapping("/order/sign")
    public int signOrder(@RequestBody SignOrderRequest signOrderRequest) {
        return orderService.signOrder(signOrderRequest);
    }

    /**
     * 拒绝订单
     *
     * @param refuseOrderRequest 拒绝订单请求对象
     * @return 拒绝订单的结果
     */
    @PostMapping("/order/refuse")
    public int refuseOrder(@RequestBody RefuseOrderRequest refuseOrderRequest) {
        return orderService.refuseOrder(refuseOrderRequest);
    }
}
