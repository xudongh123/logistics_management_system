package com.company.logistics.controller;

import com.company.logistics.controller.dto.driver.GetDriverResponse;
import com.company.logistics.controller.dto.driver.SetDriverRequest;
import com.company.logistics.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {
    private final DriverService driverService; // 司机服务

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    /**
     * 获取司机列表
     *
     * @param offset 数据偏移量
     * @param pageSize 每页数据数量
     * @param token 用户令牌
     * @return 司机列表响应对象
     */
    @GetMapping("/driver/list")
    public GetDriverResponse getDrivers(@RequestParam("offset") int offset,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam("token") String token) {
        return driverService.getDrivers(token, offset, pageSize);
    }

    /**
     * 添加司机
     *
     * @param setDriverRequest 添加司机请求对象
     * @return 添加司机的结果
     */
    @PostMapping("/driver/add")
    public int setDrivers(@RequestBody SetDriverRequest setDriverRequest) {
        return driverService.addDriver(setDriverRequest);
    }

    /**
     * 删除司机
     *
     * @param id 司机ID
     * @return 删除司机的响应实体
     */
    @DeleteMapping("/driver/delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable("id") int id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}
