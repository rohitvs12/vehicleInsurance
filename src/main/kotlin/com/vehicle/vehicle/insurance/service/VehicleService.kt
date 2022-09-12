package com.vehicle.vehicle.insurance.service

import com.vehicle.vehicle.insurance.model.Vehicle
import com.vehicle.vehicle.insurance.repository.VehicleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class VehicleService (
    @Autowired
    val vehicleRepository: VehicleRepository
) {
    fun findAllVehicles(): Flux<Vehicle> {
        return vehicleRepository.findAll()
    }

    fun updateVehicle(id: String, vehicle: Vehicle): Mono<Vehicle> {
        return vehicleRepository.findById(id)
            .flatMap {
                it.vehicleNo=vehicle.vehicleNo

                vehicleRepository.save(it)
            }
    }

}
