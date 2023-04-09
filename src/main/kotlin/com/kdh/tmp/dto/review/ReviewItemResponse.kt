package com.kdh.tmp.dto.review

import com.kdh.tmp.common.Yn
import com.kdh.tmp.domain.review.ReviewItem

data class ReviewItemResponse(
    val reviewItemId: Long,
    val metaReviewItemId: Long,
    val shortReview: String,
    val isPositive: Boolean
) {
    companion object {
        fun from(r: ReviewItem): ReviewItemResponse =
            ReviewItemResponse(
                r.reviewItemId!!,
                r.meta!!.metaReviewItemId!!,
                r.meta!!.shortReview!!,
                r.meta!!.positiveYn == Yn.Y
            )
    }
}
