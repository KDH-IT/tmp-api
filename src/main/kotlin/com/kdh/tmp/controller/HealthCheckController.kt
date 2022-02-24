package com.kdh.tmp.controller

import com.kdh.tmp.aop.ApiLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/api/ping")
    @ApiLogging
    fun healthCheck(): String {
        return "ping";
    }

}