package com.mckulpa.demo.kubernetes.apigateway.external

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class IdentityClient(
    @Value("\${external.identity.url}")
    val baseUri: String
) {
    val restTemplate = RestTemplate()

    fun createUuid(): String {
        return restTemplate.postForObject("$baseUri/uuid", HttpEntity.EMPTY, String::class.java)!!
    }

}