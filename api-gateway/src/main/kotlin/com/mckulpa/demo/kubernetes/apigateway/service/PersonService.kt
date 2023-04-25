package com.mckulpa.demo.kubernetes.apigateway.service

import com.mckulpa.demo.kubernetes.apigateway.external.IdentityClient
import com.mckulpa.demo.kubernetes.apigateway.external.NamingClient
import org.springframework.stereotype.Service

@Service
class PersonService(val identityClient: IdentityClient, val namingClient: NamingClient) {
    fun createPerson(): Person {
        return Person(identityClient.createUuid(), namingClient.createFirstname(), namingClient.createLastname())
    }
}