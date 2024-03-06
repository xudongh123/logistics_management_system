package com.company.logistics.mapper;

import com.company.logistics.model.Order;
import com.company.logistics.model.Profit;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    List<Order> getOrders(String token, int offset, int pageSize);
    Order getOrder(String id);
    int countOrdersByTokenAndStatus(String token, String status);
    //List<Map<String, Object>> countOrdersPastSevenDays(String token, String status);;
    int countOrdersByDateTokenAndStatus(String token, String status, Date time);
    int addOrder(Order order);
    int updateOrderStatus(Order order);
//
//    void deleteVehicle(int id);
}
