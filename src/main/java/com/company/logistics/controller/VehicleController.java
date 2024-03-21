package com.company.logistics.controller;

import com.company.logistics.controller.dto.vehicle.GetVehicleResponse;
import com.company.logistics.controller.dto.vehicle.SetVehicleRequest;
import com.company.logistics.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {
    private final VehicleService vehicleService; // 车辆服务

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * 获取车辆列表
     *
     * @param offset 数据偏移量
     * @param pageSize 每页数据数量
     * @param token 用户令牌
     * @return 包含车辆列表的响应对象
     */
    @GetMapping("/car/list")
    public GetVehicleResponse getVehicles(@RequestParam("offset") int offset,
                                          @RequestParam("pageSize") int pageSize,
                                          @RequestParam("token") String token) {

        return vehicleService.getVehicles(token, offset, pageSize);
    }

    /**
     * 添加车辆
     *
     * @param setVehicleRequest 设置车辆请求对象
     * @return 添加车辆的结果
     */
    @PostMapping("/car/add")
    public int setDrivers(@RequestBody SetVehicleRequest setVehicleRequest) {
        return vehicleService.addVehicle(setVehicleRequest);
    }

    /**
     * 删除车辆
     *
     * @param id 车辆ID
     * @return 删除车辆的响应
     */
    @DeleteMapping("/car/delete/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("id") int id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
