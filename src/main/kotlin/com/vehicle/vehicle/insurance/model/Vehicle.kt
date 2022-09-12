package com.vehicle.vehicle.insurance.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "vehicle")
data class Vehicle (
    @Id
    var vehicleName: String?,
    var vehicleNo: Long?,
    var vehiclebrand:String?,
    var rcno:Long?,
    var city:String?,
    var state:String?


    // var insurance:Insurance

)