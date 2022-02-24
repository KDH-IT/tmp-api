package com.kdh.tmp.dto.post

import com.kdh.tmp.domain.post.ItemPost
import com.kdh.tmp.dto.user.UserResponse
import com.kdh.tmp.util.defaultFormat
import com.kdh.tmp.dto.post.ItemPostBrief as brief

data class ItemPostBrief(
    val itemPostId: Long,
    val itemStatus: String,
    val title: String,
    val seller: UserResponse,
    val itemTitleImage: String,
    val updatedAt: String
) {
    companion object {
        fun from(p: ItemPost): brief = brief(
            p.itemPostId!!,
            p.itemStatus!!.name,
            p.title!!,
            UserResponse.from(p.seller!!),
            p.itemTitleImage!!,
            p.updatedAt!!.defaultFormat()
        )
    }
}