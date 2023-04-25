package com.mckulpa.demo.kubernetes.apigateway.rest

import com.mckulpa.demo.kubernetes.apigateway.service.Person
import com.mckulpa.demo.kubernetes.apigateway.service.PersonService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(val personService: PersonService) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(PersonController::class.java)
    }

    @PostMapping("/v1/person")
    fun createPerson(): Person {
        val person = personService.createPerson()
        log.info("Generated new person: $person")
        return person
    }

}