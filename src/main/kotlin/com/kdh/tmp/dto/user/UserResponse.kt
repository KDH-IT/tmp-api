package com.kdh.tmp.dto.user

import com.kdh.tmp.domain.user.User

data class UserResponse(val userId: Long, val phoneNumber: String, val mannerTemperature: String) {
    companion object {
        fun from(user: User): UserResponse {
            return UserResponse(user.userId!!, user.phoneNumber!!, user.mannerTemperature!!.toString())
        }
    }
}

