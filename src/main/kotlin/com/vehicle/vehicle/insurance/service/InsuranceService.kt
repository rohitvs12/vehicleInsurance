package com.vehicle.vehicle.insurance.service

import com.vehicle.vehicle.insurance.model.InsuranceBoking
import com.vehicle.vehicle.insurance.repository.InsuranceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class InsuranceService (
    @Autowired
    val insuranceRepository: InsuranceRepository
) {
    fun findAllInsurance(): Flux<InsuranceBoking> {
        return insuranceRepository.findAll()
    }

    fun addInsurance(insurance: InsuranceBoking): Mono<InsuranceBoking> {
        return insuranceRepository.save(insurance)

    }
}