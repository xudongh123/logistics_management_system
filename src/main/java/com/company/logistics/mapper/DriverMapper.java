package com.company.logistics.mapper;

import com.company.logistics.model.Driver;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverMapper {
    List<Driver> getDrivers(String token, int offset, int pageSize);

    int countDrivers(String token);

    int addDriver(Driver driver);

    void deleteDriver(int id);
}
