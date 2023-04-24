package com.mckulpa.demo.kubernetes.backend.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @GetMapping("/demo/hello")
    fun hello(): String {
        return "Hello!"
    }
}