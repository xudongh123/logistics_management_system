package com.company.logistics.controller;

import com.company.logistics.controller.dto.driver.GetDriverResponse;
import com.company.logistics.controller.dto.driver.SetDriverRequest;
import com.company.logistics.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/driver/list")
    public GetDriverResponse getDrivers(@RequestParam("offset") int offset,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam("token") String token) {

        return driverService.getDrivers(token, offset, pageSize);
    }

    @PostMapping("/driver/add")
    public int setDrivers(@RequestBody SetDriverRequest setDriverRequest) {
        return driverService.addDriver(setDriverRequest);
    }

    @DeleteMapping("/driver/delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable("id") int id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}
