package com.company.logistics.mapper;

import com.company.logistics.model.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VehicleMapper {
    List<Vehicle> getVehicles(String token, int offset, int pageSize);

    int countVehicles(String token);

    int addVehicle(Vehicle vehicle);

    void deleteVehicle(int id);
}
