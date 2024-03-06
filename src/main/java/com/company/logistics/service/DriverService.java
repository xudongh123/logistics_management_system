package com.company.logistics.service;

import java.util.Date;
import java.util.List;

import com.company.logistics.controller.dto.driver.GetDriverResponse;
import com.company.logistics.controller.dto.driver.SetDriverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.logistics.mapper.DriverMapper;
import com.company.logistics.model.Driver;

@Service
public class DriverService {

    private final DriverMapper driverMapper;

    @Autowired
    public DriverService(DriverMapper driverMapper) {
        this.driverMapper = driverMapper;
    }

    public GetDriverResponse getDrivers(String token, int offset, int pageSize) {
        List<Driver> drivers = driverMapper.getDrivers(token, offset, pageSize);
        GetDriverResponse response = new GetDriverResponse();

        int count = driverMapper.countDrivers(token);

        response.setItem(drivers);
        response.setTotal(count);
        return response;
    }

    public int addDriver(SetDriverRequest driverRequest) {
        Driver driver = new Driver();
        driver.setName(driverRequest.getName());
        driver.setPhone(driverRequest.getPhone());
        driver.setSex(driverRequest.getSex());
        driver.setIsSms(driverRequest.getIsSms());
        driver.setBankNumber(driverRequest.getBankNumber());
        driver.setBankAddr(driverRequest.getBankAddr());
        driver.setIdCard(driverRequest.getIdCard());
        driver.setEmail(driverRequest.getEmail());
        driver.setHometown(driverRequest.getHometown());
        driver.setToken(driverRequest.getToken());
        // 获取当前日期和时间
        Date now = new Date();
        driver.setTime(now);
        return driverMapper.addDriver(driver);
    }

    public void deleteDriver(int id) {
        driverMapper.deleteDriver(id);
    }
}
