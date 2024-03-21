package com.company.logistics.service;

import java.util.Date;
import java.util.List;

import com.company.logistics.controller.dto.driver.GetDriverResponse;
import com.company.logistics.controller.dto.driver.SetDriverRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.logistics.mapper.DriverMapper;
import com.company.logistics.model.Driver;

// 标识为Service组件，用于业务逻辑处理
@Service
public class DriverService {

    private final DriverMapper driverMapper;

    @Autowired
    public DriverService(DriverMapper driverMapper) {
        this.driverMapper = driverMapper;
    }

    // 获取司机列表
    public GetDriverResponse getDrivers(String token, int offset, int pageSize) {
        // 调用Mapper获取司机列表数据
        List<Driver> drivers = driverMapper.getDrivers(token, offset, pageSize);
        GetDriverResponse response = new GetDriverResponse();

        // 获取司机总数
        int count = driverMapper.countDrivers(token);

        // 设置响应数据
        response.setItem(drivers);
        response.setTotal(count);
        return response;
    }

    // 添加司机
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

        return driverMapper.addDriver(driver);  // 调用Mapper添加司机
    }

    // 删除司机
    public void deleteDriver(int id) {
        driverMapper.deleteDriver(id);  // 调用Mapper删除司机
    }
}
