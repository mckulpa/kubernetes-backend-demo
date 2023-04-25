package com.mckulpa.demo.kubernetes.naming.rest

import net.datafaker.Faker
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NamingController {

    companion object {
        val log: Logger = LoggerFactory.getLogger(NamingController::class.java)
    }

    val faker = Faker()

    @PostMapping("/v1/firstname")
    fun createFirstname(): String {
        val name = faker.name().firstName()
        log.info("Generated new Firstname: $name")
//        return name
        return "John" // Bug!
    }

    @PostMapping("/v1/lastname")
    fun createLastname(): String {
        val name = faker.name().lastName()
        log.info("Generated new Lastname: $name")
        return name
    }
}