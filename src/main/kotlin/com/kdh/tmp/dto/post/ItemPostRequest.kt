package com.kdh.tmp.dto.post

import com.kdh.tmp.domain.post.ItemPost
import com.kdh.tmp.domain.post.ItemPostStatus
import com.kdh.tmp.domain.user.User

data class ItemPostRequest(
    val itemStatus: ItemPostStatus,
    val title: String,
    val content: String,
    val sellerId: Long,
    val buyerId: Long?,
    val itemImageUrl: String
) {
    fun createItemPost(): ItemPost {
        return copyToEntity(old = ItemPost())
    }

    fun copyToEntity(old: ItemPost): ItemPost {
        return old.also {
            it.itemStatus = this.itemStatus
            it.title = this.title
            it.content = this.content
            it.seller = User().also { user -> user.userId = sellerId }
            it.buyer = if (buyerId == null) null else User().also { user -> user.userId = buyerId }
            it.itemTitleImage = this.itemImageUrl
        }
    }
}