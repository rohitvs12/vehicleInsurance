package com.vehicle.vehicle.insurance.service

import com.vehicle.vehicle.insurance.model.User
import com.vehicle.vehicle.insurance.repository.UserRepository
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
internal class UserServiceTest{

    val user1 = User("1","Rohit" ,  "abcd" , "hi@gmail.com",7676767676,"hiiiii")



    private val userRepository = mockk<UserRepository>(){

        every {
            userService.findAllUsers()
        } returns Flux.just(user1)

    }



    private val userService = UserService(u)


    @Test
    fun `should return Users when findAllUsers method is called`() {

        val user1 =  userService.findAllUsers().blockFirst()


        user1 shouldBe user1
    }
}