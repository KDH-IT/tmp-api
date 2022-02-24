package com.kdh.tmp.controller.crud

import com.kdh.tmp.domain.user.User
import com.kdh.tmp.domain.user.UserRepository
import com.kdh.tmp.dto.user.UserListResponse
import com.kdh.tmp.dto.user.UserRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
class UserController(val userRepository: UserRepository) {

    @GetMapping("/api/user/{user_id}")
    fun getUser(@PathVariable("user_id") userId: Long): User =
        userRepository.findById(userId).orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) }

    @Transactional
    @PostMapping("/api/user")
    fun createUser(@RequestBody requestBody: UserRequest): User =
        userRepository.save(requestBody.createUser())

    @DeleteMapping("/api/user/{user_id}")
    fun deleteUser(@PathVariable("user_id") userId: Long) {
        try {
            userRepository.deleteById(userId)
        } catch (ignored: EmptyResultDataAccessException) {
            // do nothing
        }
    }
    @GetMapping("/api/user")
    fun findAllUsers(): UserListResponse = UserListResponse(userRepository.findAll())
}