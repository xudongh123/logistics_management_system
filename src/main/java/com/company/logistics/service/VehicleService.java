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

    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleService(VehicleMapper vehicleMapper) {
        this.vehicleMapper = vehicleMapper;
    }

    public GetVehicleResponse getVehicles(String token, int offset, int pageSize) {
        List<Vehicle> drivers = vehicleMapper.getVehicles(token, offset, pageSize);
        GetVehicleResponse response = new GetVehicleResponse();

        int count = vehicleMapper.countVehicles(token);
        response.setItem(drivers);
        response.setTotal(count);
        return response;
    }

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
        // Getting the current date and time
        Date now = new Date();
        vehicle.setTime(now);
        return vehicleMapper.addVehicle(vehicle);
    }

    public void deleteVehicle(int id) {
        vehicleMapper.deleteVehicle(id);
    }
}
