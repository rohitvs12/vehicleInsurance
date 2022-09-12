package com.vehicle.vehicle.insurance.controller

import ch.qos.logback.core.net.server.Client
import com.vehicle.vehicle.insurance.model.User
import com.vehicle.vehicle.insurance.service.UserService
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.returnResult
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@WebFluxTest(UserController::class)
@AutoConfigureWebTestClient
class             UserControllerTest {

    @Autowired
    lateinit var client : WebTestClient

    @Autowired
    lateinit var userService : UserService

    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun userService() = mockk<UserService>()
    }

    @Test
    fun `should return list of all the users`() {

        val user1 = User("1","Rohit" ,  "abcd" , "hi@gmail.com",7676767676,"hiiiii")


        val expectedResult =
            mapOf("user_id" to "1",
                "first_name" to "Rohit",
                "last_name" to "abcd",
                "email" to "hi@gmail.com",
                "phone_num" to 7676767676,
                "password" to "hiiiii")


        every {
            userService.findAllUsers()
        } returns Flux.just(user1)

        val response = client.get()
            .uri("/api/v1/users/list")
            .accept(MediaType.APPLICATION_JSON)
            .exchange() //invoking the end point
            .expectStatus().is2xxSuccessful
            .returnResult<Any>()
            .responseBody

        response.blockFirst() shouldBe expectedResult
                    //response.blockLast() shouldBe expectedResult[1]

        verify(exactly = 1) {
            userService.findAllUsers()
        }
    }
    @Test
    fun `should create user when create api is being called`() {

        val  exepectedResponse =
            mapOf("user_id" to "1",
                "first_name" to "Rohit",
                "last_name" to "abcd",
                "email" to "hi@gmail.com",
                "phone_num" to 7676767676,
                "password" to "hiiiii")

        val user = User("1","Rohit" ,  "abcd" , "hi@gmail.com",7676767676,"hiiiii")

        every {
            userService.addUser(user)
        } returns Mono.just(user)

        val response = client.post()
            .uri("/api/v1/users/add")
            .bodyValue(user)
            .exchange()
            .expectStatus().is2xxSuccessful
            .returnResult<Any>().responseBody

        response.blockFirst() shouldBe exepectedResponse

        verify(exactly = 1) {
            userService.addUser(user)
        }
    }
    @Test
    fun `should be able to update the book present in the online user`() {

        val expectedResult =
            mapOf("user_id" to "1",
                "first_name" to "Rohit",
                "last_name" to "abcd",
                "email" to "hi@gmail.com",
                "phone_num" to 7676767676,
                "password" to "hiiiii")

        val user1 = User("1","Rohit" ,  "abcd" , "hi@gmail.com",7676767676,"hiiiii")



        every {
            userService.updateUser("1",user1)
        } returns Mono.just(user1)

        val response = client.put()
            .uri("/api/v1/user/update/1")
            .bodyValue(user1)
            .exchange()
            .expectStatus().is2xxSuccessful

        verify(exactly = 1) {
            userService.updateUser("1",user1)
        }
    }


}

