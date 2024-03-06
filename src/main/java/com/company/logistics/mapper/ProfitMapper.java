package com.company.logistics.mapper;

import com.company.logistics.model.Profit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfitMapper {
    List<Profit> getProfits(String token, int offset, int pageSize);

    int addProfit(Profit profit);

    int updateReceive(Profit profit);
    int updatePay(Profit profit);
//
//    void deleteVehicle(int id);
}
