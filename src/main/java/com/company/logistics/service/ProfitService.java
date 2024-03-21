package com.company.logistics.service;

import java.util.Date;
import java.util.List;

import com.company.logistics.controller.dto.profit.GetProfitResponse;
import com.company.logistics.controller.dto.profit.UpdatePayRequest;
import com.company.logistics.controller.dto.profit.UpdateReceiveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.logistics.mapper.ProfitMapper;
import com.company.logistics.model.Profit;

@Service
public class ProfitService {
    private final ProfitMapper profitMapper; // 利润映射器

    @Autowired
    public ProfitService(ProfitMapper profitMapper) {
        this.profitMapper = profitMapper;
    }

    // 获取利润列表
    public GetProfitResponse getProfits(String token, int offset, int pageSize) {
        List<Profit> profits = profitMapper.getProfits(token, offset, pageSize);
        int count = profitMapper.countProfits(token);

        GetProfitResponse response = new GetProfitResponse();
        response.setItem(profits);
        response.setTotal(count);
        return response;
    }

    // 添加利润记录
    public int addProfit(String id, int pay, int receive, String token) {
        Profit profit = new Profit();

        profit.setId(id);
        profit.setPay(pay);
        profit.setPayNow(0);
        profit.setIsPay(false);
        profit.setReceive(receive);
        profit.setReceiveNow(0);
        profit.setIsReceive(false);
        profit.setToken(token);

        Date now = new Date();
        profit.setTime(now);

        return profitMapper.addProfit(profit);
    }

    // 更新收款信息
    public int updateReceive(UpdateReceiveRequest updateReceiveRequest, String id) {
        Profit profit = new Profit();
        profit.setId(id);
        profit.setReceiveNow(updateReceiveRequest.getReceive());
        profit.setIsReceive(updateReceiveRequest.getIsReceive());
        return profitMapper.updateReceive(profit);
    }

    // 更新付款信息
    public int updatePay(UpdatePayRequest updatePayRequest, String id) {
        Profit profit = new Profit();
        profit.setId(id);
        profit.setPayNow(updatePayRequest.getPay());
        profit.setIsPay(updatePayRequest.getIsPay());
        return profitMapper.updatePay(profit);
    }
}
