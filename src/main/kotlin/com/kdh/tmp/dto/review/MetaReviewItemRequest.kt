package com.kdh.tmp.dto.review

import com.kdh.tmp.common.Yn
import com.kdh.tmp.domain.review.MetaReviewItem

data class MetaReviewItemRequest(
    val itemContent: String,
    val isPositive: Boolean,
    val adminUser: String
) {
    fun createMetaReviewContent(): MetaReviewItem = copyTo(MetaReviewItem())

    fun copyTo(entity:MetaReviewItem): MetaReviewItem =
        entity.also {
            it.shortReview = this.itemContent
            it.positiveYn = if (this.isPositive) Yn.Y else Yn.N
            it.updatedBy = this.adminUser
        }
}
