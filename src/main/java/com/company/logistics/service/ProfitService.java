package com.company.logistics.service;

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
    private final ProfitMapper profitMapper;

    @Autowired
    public ProfitService(ProfitMapper profitMapper) {
        this.profitMapper = profitMapper;
    }

    public GetProfitResponse getProfits(String token, int offset, int pageSize) {
        List<Profit> orders = profitMapper.getProfits(token, offset, pageSize);
        GetProfitResponse response = new GetProfitResponse();
        response.setItem(orders);
        return response;
    }

    public  int addProfit(String id, int pay, int receive, String token) {
        Profit profit = new Profit();

        profit.setId(id);
        profit.setPay(pay);
        profit.setPayNow(0);
        profit.setIsPay(false);
        profit.setReceive(receive);
        profit.setReceiveNow(0);
        profit.setIsReceive(false);
        profit.setToken(token);

        return profitMapper.addProfit(profit);
    }

    public  int updateReceive(UpdateReceiveRequest updateReceiveRequest, String id) {
        Profit profit = new Profit();
        profit.setId(id);
        profit.setReceiveNow(updateReceiveRequest.getReceive());
        profit.setIsReceive(updateReceiveRequest.getIsReceive());
        return profitMapper.updateReceive(profit);
    }
    public  int updatePay(UpdatePayRequest updatePayRequest, String id) {
        Profit profit = new Profit();
        profit.setId(id);
        profit.setPayNow(updatePayRequest.getPay());
        profit.setIsPay(updatePayRequest.getIsPay());
        return profitMapper.updatePay(profit);
    }
}
