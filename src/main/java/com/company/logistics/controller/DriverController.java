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

    @GetMapping("/v1/fleet/driver/ex/page")
    public GetDriverResponse getDrivers(@RequestParam("offset") int offset,
                                        @RequestParam("pageSize") int pageSize,
                                        @RequestParam("token") String token) {

        return driverService.getDrivers(token, offset, pageSize);
    }

    @PostMapping("/v1/fleet/driver/ex")
    public int setDrivers(@RequestBody SetDriverRequest setDriverRequest) {
        return driverService.addDriver(setDriverRequest);
    }

    @DeleteMapping("/v1/fleet/driver/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable("id") int id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}
