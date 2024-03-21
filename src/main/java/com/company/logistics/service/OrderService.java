package com.company.logistics.service;

import java.util.*;

import com.company.logistics.controller.dto.order.*;
import com.company.logistics.mapper.GoodsMapper;
import com.company.logistics.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.logistics.mapper.OrderMapper;
import com.company.logistics.model.Order;

@Service
public class OrderService {

    private final OrderMapper orderMapper; // 订单映射器
    private final GoodsMapper goodsMapper; // 商品映射器
    private final ProfitService profitService; // 利润服务
    private final GoodsService goodsService; // 商品服务

    @Autowired
    public OrderService(OrderMapper orderMapper, GoodsMapper goodsMapper, ProfitService profitService, GoodsService goodsService) {
        this.orderMapper = orderMapper;
        this.goodsMapper = goodsMapper;
        this.profitService = profitService;
        this.goodsService = goodsService;
    }

    // 获取订单列表
    public GetOrderResponse getOrders(String token, int offset, int pageSize) {
        List<Order> orders = orderMapper.getOrders(token, offset, pageSize);
        int count = orderMapper.countOrders(token);
        GetOrderResponse response = new GetOrderResponse();
        response.setItem(orders);
        response.setTotal(count);

        return response;
    }

    // 获取单个订单详情
    public Map<String, Object> getOrder(String id) {
        Map<String, Object> result = new HashMap<>();
        Order order = orderMapper.getOrder(id);
        List<Goods> goods = goodsMapper.getGoods(id);
        result.put("orderCustomer", order);
        result.put("orderGoods", goods);
        return result;
    }

    // 根据token统计不同状态的订单数量
    public Map<String, Integer> countOrdersByToken(String token) {
        // 定义一个Map来存储每种状态的订单总数，这次使用更具体的键名
        Map<String, Integer> statusCounts = new HashMap<>();

        int totalOrderCount = 0;

        // 创建一个Map将状态的数据库表示映射到前端期望的键名
        Map<String, String> statusToKeyMap = new HashMap<>();
        statusToKeyMap.put("ORDER_TAKING", "orderTakingCount");
        statusToKeyMap.put("ORDER_SIGN", "orderSignCount");
        statusToKeyMap.put("ORDER_PLACE", "orderPlaceCount");
        statusToKeyMap.put("ORDER_REFUSE", "orderRefuseCount");

        // 遍历每种状态，分别进行查询，并将结果存储到Map中
        for (Map.Entry<String, String> entry : statusToKeyMap.entrySet()) {
            String status = entry.getKey();
            String key = entry.getValue();
            int count = orderMapper.countOrdersByTokenAndStatus(token, status);
            statusCounts.put(key, count);
            totalOrderCount += count;
        }
        statusCounts.put("totalOrderCount", totalOrderCount);
        return statusCounts;
    }

    // 统计近7天订单数量
    public Map<String, Object> countOrdersPastSevenDays(String token) {
        Map<String, Object> result = new HashMap<>();

        Map<String, String> statusToKeyMap = new HashMap<>();
        statusToKeyMap.put("ORDER_TAKING", "takingCount");
        statusToKeyMap.put("ORDER_SIGN", "orderSignCount");
        statusToKeyMap.put("ORDER_PLACE", "placeCount");
        statusToKeyMap.put("ORDER_REFUSE", "refuseCount");

        // 获取七天内所有日期
        List<Date> dates = get7DayDates();

        for (Map.Entry<String, String> entry : statusToKeyMap.entrySet()) {
            String status = entry.getKey();
            String key = entry.getValue();
            List<Integer> countList = new ArrayList<>();
            for (Date date : dates) {
                int count = orderMapper.countOrdersByDateTokenAndStatus(token, status, date);
                countList.add(count);
            }
            result.put(key, countList);
        }
        result.put("timeList", dates);
        return result;
    }

    // 获取近7天日期列表
    private static List<Date> get7DayDates() {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);

        calendar.add(Calendar.DAY_OF_MONTH, -6);

        for (int i = 0; i <= 6; i++) {
            dates.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1); // 向前移动一天
        }
        return dates;
    }

    // 添加订单
    public int addOrder(SetOrderRequest orderRequest) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        for (SetOrderRequest.GoodsRequest goodsRequest : orderRequest.getGoods()) {
            goodsService.addGoods(goodsRequest, randomUUIDString);
        }

        Order order = new Order();

        order.setId(randomUUIDString);
        order.setOrderNumber(randomUUIDString);
        order.setStatus("ORDER_PLACE");
        order.setSendName(orderRequest.getSendName());
        order.setSendPhone(orderRequest.getSendPhone());
        order.setSendAddr(orderRequest.getSendAddr());
        order.setSendAddrInfo(orderRequest.getSendAddrInfo());
        order.setReceiveName(orderRequest.getReceiveName());
        order.setReceivePhone(orderRequest.getReceivePhone());
        order.setReceiveAddr(orderRequest.getReceiveAddr());
        order.setReceiveAddrInfo(orderRequest.getReceiveAddrInfo());
        order.setDispatchingType(orderRequest.getDispatchingType());
        order.setSendTime(orderRequest.getSendTime());
        order.setReceiveTime(orderRequest.getReceiveTime());
        order.setIsCompany(orderRequest.isCompany());
        order.setToken(orderRequest.getToken());
        Date now = new Date();
        order.setTime(now);

        return orderMapper.addOrder(order);
    }

    // 接受订单
    public int takingOrder(TakingOrderRequest takingOrderRequest) {
        Order order = new Order();
        order.setId(takingOrderRequest.getId());
        order.setStatus("ORDER_TAKING");
        orderMapper.updateOrderStatus(order);
        return profitService.addProfit(takingOrderRequest.getId(), takingOrderRequest.getPay(), takingOrderRequest.getReceive(), takingOrderRequest.getToken());
    }

    // 签收订单
    public int signOrder(SignOrderRequest signOrderRequest) {
        Order order = new Order();
        order.setId(signOrderRequest.getId());
        order.setStatus("ORDER_SIGN");
        return orderMapper.updateOrderStatus(order);
    }

    // 拒绝订单
    public int refuseOrder(RefuseOrderRequest refuseOrderRequest) {
        Order order = new Order();
        order.setId(refuseOrderRequest.getId());
        order.setStatus("ORDER_REFUSE");
        return orderMapper.updateOrderStatus(order);
    }
}
