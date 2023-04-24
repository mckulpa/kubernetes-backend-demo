package com.mckulpa.demo.kubernetes.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KubernetesBackendDemoApplication

fun main(args: Array<String>) {
	runApplication<KubernetesBackendDemoApplication>(*args)
}
