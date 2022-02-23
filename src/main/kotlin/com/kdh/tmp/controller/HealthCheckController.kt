package com.kdh.tmp.controller

import com.kdh.tmp.domain.user.User
import com.kdh.tmp.domain.user.UserRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController(val userRepository: UserRepository) {

    @GetMapping("/api/ping")
    fun healthCheck(): String {
        return "ping";
    }

}