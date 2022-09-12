package com.vehicle.vehicle.insurance.repository

import com.vehicle.vehicle.insurance.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UserRepository: ReactiveMongoRepository<User, String> {



}