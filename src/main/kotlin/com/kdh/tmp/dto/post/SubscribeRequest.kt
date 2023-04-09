package com.kdh.tmp.dto.post

import com.kdh.tmp.domain.post.ItemPost
import com.kdh.tmp.domain.post.Subscribe
import com.kdh.tmp.domain.user.User

data class SubscribeRequest(val userId: Long, val itemPostId: Long) {

    fun createSubscribe(): Subscribe = Subscribe().also {
        it.subscriber = User().also { user -> user.userId = this.userId }
        it.itemPost = ItemPost().also { post -> post.itemPostId = this.itemPostId }
    }
}