package com.kdh.tmp.dto.post

import com.kdh.tmp.domain.post.ItemPost
import com.kdh.tmp.dto.user.UserResponse
import com.kdh.tmp.util.defaultFormat
import com.kdh.tmp.dto.post.ItemPostDetailResponse as detail

data class ItemPostDetailResponse(
    val itemPostId: Long,
    val itemStatus: String,
    val title: String,
    val content: String,
    val seller: UserResponse,
    val buyer: UserResponse,
    val itemTitleImage: String,
    val createdAt: String,
    val updatedAt: String
) {
    companion object {
        fun from(p: ItemPost): detail = detail(
            p.itemPostId!!,
            p.itemStatus!!.name,
            p.title!!,
            p.content!!,
            UserResponse.from(p.seller!!),
            UserResponse.from(p.buyer!!),
            p.itemTitleImage!!,
            p.createdAt!!.defaultFormat(),
            p.updatedAt!!.defaultFormat()
        )
    }
}

