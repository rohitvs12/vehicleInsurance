package com.vehicle.vehicle.insurance.service

import com.vehicle.vehicle.insurance.model.User
import com.vehicle.vehicle.insurance.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService (
    @Autowired
    val userRepository: UserRepository
) {
    fun findAllUsers(): Flux<User> {
        return userRepository.findAll()
    }


    fun addUser(user: User): Mono<User> {
        return userRepository.save(user)

    }

    fun updateUser(id: String, user: User): Mono<User> {
        return userRepository.findById(id)
            .flatMap {
                it.user_id= user.user_id
                it.phone_num = user.phone_num
                it.first_name=user.first_name
                it.last_name=user.last_name
                it.email=user.email
                it.password=user.password

                userRepository.save(it)
            }
    }

    fun deleteById(id: String): Mono<Void> {
        return userRepository.deleteById(id)
    }

}