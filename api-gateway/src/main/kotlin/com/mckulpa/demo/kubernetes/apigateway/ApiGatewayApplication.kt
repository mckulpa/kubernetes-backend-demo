package com.mckulpa.demo.kubernetes.apigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NamingApplication

fun main(args: Array<String>) {
	runApplication<NamingApplication>(*args)
}
