package com.mckulpa.demo.kubernetes.identity.rest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UuidController {

    companion object {
        val log: Logger = LoggerFactory.getLogger(UuidController::class.java)
    }

    @PostMapping("/v1/uuid")
    fun createUuid(): String {
        val id = UUID.randomUUID().toString()
        log.info("Generated new ID: $id")
        return id
    }
}