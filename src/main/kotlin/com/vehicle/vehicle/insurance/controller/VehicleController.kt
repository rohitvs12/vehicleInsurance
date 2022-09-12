package com.vehicle.vehicle.insurance.controller

import com.vehicle.vehicle.insurance.model.Vehicle
import com.vehicle.vehicle.insurance.service.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1")
class VehicleController (
    @Autowired
    val vehicleService: VehicleService
) {
    @GetMapping("/vehicle")

    fun getAllVehicles(): Flux<Vehicle> {
        return vehicleService.findAllVehicles()
    }


    @PutMapping("/vehicle/update/{id}")
    fun updateVehicleById(@PathVariable("id") id: String, @RequestBody vehicle:Vehicle): Mono<Vehicle> {
        return vehicleService.updateVehicle(id, vehicle)
    }




}