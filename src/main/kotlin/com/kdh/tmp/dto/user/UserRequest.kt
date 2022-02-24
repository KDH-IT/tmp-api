package com.kdh.tmp.dto.user

import com.kdh.tmp.domain.user.User

data class UserRequest(val phoneNumber: String) {

    fun createUser(): User = User().also { it.phoneNumber = this.phoneNumber }
}