package com.vehicle.vehicle.insurance.model

import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "payment")
data class Payment(
    var cardno :Long,
    var nameoncard:String,
    var cvv :Int
)