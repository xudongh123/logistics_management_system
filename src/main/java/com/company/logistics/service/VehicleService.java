package com.company.logistics.service;

import java.util.Date;
import java.util.List;

import com.company.logistics.controller.dto.vehicle.GetVehicleResponse;
import com.company.logistics.controller.dto.vehicle.SetVehicleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.logistics.mapper.VehicleMapper;
import com.company.logistics.model.Vehicle;

@Service
public class VehicleService {

    private final VehicleMapper vehicleMapper; // 车辆映射器

    @Autowired
    public VehicleService(VehicleMapper vehicleMapper) {
        this.vehicleMapper = vehicleMapper;
    }

    /**
     * 获取车辆信息
     *
     * @param token 用户令牌
     * @param offset 数据偏移量
     * @param pageSize 每页数据数量
     * @return 车辆信息响应对象
     */
    public GetVehicleResponse getVehicles(String token, int offset, int pageSize) {
        List<Vehicle> vehicles = vehicleMapper.getVehicles(token, offset, pageSize);
        GetVehicleResponse response = new GetVehicleResponse();

        int count = vehicleMapper.countVehicles(token);
        response.setItem(vehicles);
        response.setTotal(count);
        return response;
    }

    /**
     * 添加车辆信息
     *
     * @param vehicleRequest 车辆信息请求对象
     * @return 添加车辆的结果
     */
    public int addVehicle(SetVehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(vehicleRequest.getPlate());
        vehicle.setType(vehicleRequest.getType());
        vehicle.setResource(vehicleRequest.getResource());
        vehicle.setTwoPlate(vehicleRequest.getTwoPlate());
        vehicle.setDriverPhone(vehicleRequest.getDriverPhone());
        vehicle.setDriverName(vehicleRequest.getDriverName());
        vehicle.setEnergy(vehicleRequest.getEnergy());
        vehicle.setLength(vehicleRequest.getLength());
        vehicle.setWeight(vehicleRequest.getWeight());
        vehicle.setVin(vehicleRequest.getVin());
        vehicle.setBrand(vehicleRequest.getBrand());
        vehicle.setEngine(vehicleRequest.getEngine());
        vehicle.setAxle(vehicleRequest.getAxle());
        vehicle.setWheelbase(vehicleRequest.getWheelbase());
        vehicle.setTire(vehicleRequest.getTire());
        vehicle.setFactoryTime(vehicleRequest.getFactoryTime());
        vehicle.setBuyTime(vehicleRequest.getBuyTime());
        vehicle.setBuyPrice(vehicleRequest.getBuyPrice());
        vehicle.setLimitedTime(vehicleRequest.getLimitedTime());
        vehicle.setRemark(vehicleRequest.getRemark());
        vehicle.setToken(vehicleRequest.getToken());

        // 获取当前日期和时间
        Date now = new Date();
        vehicle.setTime(now);
        return vehicleMapper.addVehicle(vehicle);
    }

    /**
     * 删除车辆信息
     *
     * @param id 车辆ID
     */
    public void deleteVehicle(int id) {
        vehicleMapper.deleteVehicle(id);
    }
}
