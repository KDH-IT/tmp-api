package com.kdh.tmp.dto.post

import com.kdh.tmp.domain.post.Subscribe
import com.kdh.tmp.dto.user.UserResponse

data class SubscribeResponse(
    val subscribeId: Long,
    val subscriber: UserResponse,
    val itemPost: ItemPostBrief
) {
    companion object {
        fun from(subscribe: Subscribe): SubscribeResponse =
            SubscribeResponse(
                subscribe.subscribeId!!,
                UserResponse.from(subscribe.subscriber!!),
                ItemPostBrief.from(subscribe.itemPost!!)
            )
    }
}
