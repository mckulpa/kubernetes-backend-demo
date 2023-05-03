package com.mckulpa.demo.kubernetes.apigateway.rest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.availability.AvailabilityChangeEvent
import org.springframework.boot.availability.AvailabilityState
import org.springframework.boot.availability.LivenessState
import org.springframework.boot.availability.ReadinessState
import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Allows to set Liveness and Readiness states manually for demonstration purposes.
 *
 * These states are exposed on the following endpoints:
 * * `/actuator/health/liveness`
 * * `/actuator/health/readiness`
 * * `/actuator/health` (combined)
 *
 */
@RestController
class AvailabilityController(val eventPublisher: ApplicationEventPublisher) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(AvailabilityController::class.java)
    }

    @PostMapping("/availability/liveness", consumes = ["text/plain"])
    fun breakLiveness(@RequestBody state: String) {
        publish(LivenessState.valueOf(state))
    }

    @PostMapping("/availability/readiness", consumes = [MediaType.TEXT_PLAIN_VALUE])
    fun breakReadiness(@RequestBody state: String) {
        publish(ReadinessState.valueOf(state))
    }

    private fun publish(state: AvailabilityState) {
        log.info("Publishing AvailabilityState: $state")
        AvailabilityChangeEvent.publish(this.eventPublisher, this, state)
    }
}