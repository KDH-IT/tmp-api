package com.kdh.tmp.dto.review

import com.kdh.tmp.common.Yn
import com.kdh.tmp.domain.review.MetaReviewContent

data class MetaReviewContentRequest(
    val itemContent: String,
    val isPositive: Boolean,
    val adminUser: String
) {
    fun createMetaReviewContent(): MetaReviewContent =
        MetaReviewContent().also {
            it.itemContent = this.itemContent
            it.positiveYn = if (this.isPositive) Yn.Y else Yn.N
            it.updatedBy = this.adminUser
        }

    fun updateMetaReviewContent(entity:MetaReviewContent): MetaReviewContent =
        entity.also {
            it.itemContent = this.itemContent
            it.positiveYn = if (this.isPositive) Yn.Y else Yn.N
            it.updatedBy = this.adminUser
        }
}
