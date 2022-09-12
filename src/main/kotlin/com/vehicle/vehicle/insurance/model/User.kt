package com.vehicle.vehicle.insurance.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(

    @Id
    var user_id: String?,
    var first_name: String?,
    var last_name: String?,
    var email: String?,
    var phone_num:Long?,
    var password:String?,


)