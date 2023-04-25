package com.mckulpa.demo.kubernetes.apigateway.external

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class NamingClient(
    @Value("\${external.naming.url}")
    val baseUri: String
) {
    val restTemplate = RestTemplate()

    fun createFirstname(): String {
        return restTemplate.postForObject("$baseUri/firstname", HttpEntity.EMPTY, String::class.java)!!
    }

    fun createLastname(): String {
        return restTemplate.postForObject("$baseUri/lastname", HttpEntity.EMPTY, String::class.java)!!
    }
}