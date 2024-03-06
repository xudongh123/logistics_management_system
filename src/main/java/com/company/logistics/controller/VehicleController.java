package com.company.logistics.controller;

import com.company.logistics.controller.dto.vehicle.GetVehicleResponse;
import com.company.logistics.controller.dto.vehicle.SetVehicleRequest;
import com.company.logistics.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/car/list")
    public GetVehicleResponse getVehicles(@RequestParam("offset") int offset,
                                         @RequestParam("pageSize") int pageSize,
                                         @RequestParam("token") String token) {

        return vehicleService.getVehicles(token, offset, pageSize);
    }

    @PostMapping("/car/add")
    public int setDrivers(@RequestBody SetVehicleRequest setVehicleRequest) {
        return vehicleService.addVehicle(setVehicleRequest);
    }

    @DeleteMapping("/car/delete/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("id") int id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
