package com.company.logistics.controller;

import com.company.logistics.controller.dto.profit.GetProfitResponse;
import com.company.logistics.controller.dto.profit.UpdatePayRequest;
import com.company.logistics.controller.dto.profit.UpdateReceiveRequest;
import com.company.logistics.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfitController {
    private final ProfitService profitService; // 利润服务

    @Autowired
    public ProfitController(ProfitService profitService) {
        this.profitService = profitService;
    }

    /**
     * 获取利润列表
     *
     * @param offset 数据偏移量
     * @param pageSize 每页数据数量
     * @param token 用户令牌
     * @return 利润列表响应对象
     */
    @GetMapping("/profit/list")
    public GetProfitResponse getOrders(@RequestParam("offset") int offset,
                                       @RequestParam("pageSize") int pageSize,
                                       @RequestParam("token") String token) {
        return profitService.getProfits(token, offset, pageSize);
    }

    /**
     * 更新收款信息
     *
     * @param updateReceiveRequest 更新收款请求对象
     * @param id 利润ID
     * @return 更新收款信息的结果
     */
    @PostMapping("/profit/receive/{id}")
    public int updateReceive(@RequestBody UpdateReceiveRequest updateReceiveRequest, @PathVariable String id) {
        return profitService.updateReceive(updateReceiveRequest, id);
    }

    /**
     * 更新支付信息
     *
     * @param updatePayRequest 更新支付请求对象
     * @param id 利润ID
     * @return 更新支付信息的结果
     */
    @PostMapping("/v1/profit/pay/{id}")
    public int updatePay(@RequestBody UpdatePayRequest updatePayRequest, @PathVariable String id) {
        return profitService.updatePay(updatePayRequest, id);
    }

}
