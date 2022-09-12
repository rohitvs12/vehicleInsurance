package com.vehicle.vehicle.insurance.controller

import com.vehicle.vehicle.insurance.model.InsuranceBoking
import com.vehicle.vehicle.insurance.service.InsuranceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@CrossOrigin(origins = ["http://localhost:3000"], maxAge=3600, allowCredentials = "true")
@RestController
@RequestMapping("/insurance")
class InsuranceController (
    @Autowired
    val insuranceService: InsuranceService
)
{
    @GetMapping("/list")

    fun getAllInsurances(): Flux<InsuranceBoking> {
        return insuranceService.findAllInsurance()
    }
    @PostMapping("/add")
    fun createInsurance(@RequestBody insurance: InsuranceBoking): Mono<InsuranceBoking> {
        return insuranceService.addInsurance(insurance)
    }




}