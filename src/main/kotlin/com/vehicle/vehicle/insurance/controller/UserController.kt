package com.vehicle.vehicle.insurance.controller

import com.vehicle.vehicle.insurance.model.User
import com.vehicle.vehicle.insurance.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1")
class UserController (
    @Autowired

    val userService: UserService
)
{
    @GetMapping("/users/list")

    fun getAllUsers(): Flux<User> {
        return userService.findAllUsers()
    }




    @PostMapping("/users/add")
    fun createUser(@RequestBody user: User): Mono<User> {
        return userService.addUser(user)
    }

    @PutMapping("/user/update/{id}")
    fun updateUserById(@PathVariable("id") id: String, @RequestBody user:User): Mono<User> {
        return userService.updateUser(id, user)
    }
    @DeleteMapping("/user/delete/{id}")
    fun deleteUserById(@PathVariable("id") id: String): Mono<Void> {
        return userService.deleteById(id)
    }

}


