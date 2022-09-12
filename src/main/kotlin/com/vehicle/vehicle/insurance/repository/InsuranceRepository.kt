package com.vehicle.vehicle.insurance.repository

import com.vehicle.vehicle.insurance.model.InsuranceBoking
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface InsuranceRepository: ReactiveMongoRepository<InsuranceBoking, String> {

}