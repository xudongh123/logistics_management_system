package com.company.logistics.controller;

import com.company.logistics.controller.dto.profit.GetProfitResponse;
import com.company.logistics.controller.dto.profit.UpdatePayRequest;
import com.company.logistics.controller.dto.profit.UpdateReceiveRequest;
import com.company.logistics.service.ProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfitController {
    private final ProfitService profitService;

    @Autowired
    public ProfitController(ProfitService profitService) {
        this.profitService = profitService;
    }

    @GetMapping("/v1/profit/page")
    public GetProfitResponse getOrders(@RequestParam("offset") int offset,
                                      @RequestParam("pageSize") int pageSize,
                                      @RequestParam("token") String token) {

        return profitService.getProfits(token, offset, pageSize);
    }

    @PostMapping("/v1/profit/receive/{id}")
    public int updateReceive(@RequestBody UpdateReceiveRequest updateReceiveRequest, @PathVariable String id) {
        return profitService.updateReceive(updateReceiveRequest, id);
    }

    @PostMapping("/v1/profit/pay/{id}")
    public int updatePay(@RequestBody UpdatePayRequest updatePayRequest, @PathVariable String id) {
        return profitService.updatePay(updatePayRequest, id);
    }
//
//    @DeleteMapping("/v1/fleet/driver/{id}")
//    public ResponseEntity<Void> deleteDriver(@PathVariable("id") int id) {
//        driverService.deleteDriver(id);
//        return ResponseEntity.noContent().build();
//    }
}
