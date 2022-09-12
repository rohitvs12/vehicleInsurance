package com.vehicle.vehicle.insurance.repository

import com.vehicle.vehicle.insurance.model.Vehicle
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface VehicleRepository: ReactiveMongoRepository<Vehicle, String> {


}