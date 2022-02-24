package com.kdh.tmp.dto.review

import com.kdh.tmp.domain.review.Review
import com.kdh.tmp.dto.user.UserResponse
import com.kdh.tmp.util.defaultFormat

data class ReviewResponse(
    val reviewId: Long,
    val reviewComment: String,
    val reviewer: UserResponse,
    val reviewee: UserResponse,
    val createdAt: String,
    val updatedAt: String,
    val reviewItems: List<ReviewItemResponse>
) {
    companion object {
        fun from(r: Review): ReviewResponse =
            ReviewResponse(
                r.reviewId!!,
                r.reviewComment!!,
                UserResponse.from(r.reviewer!!),
                UserResponse.from(r.reviewee!!),
                r.createdAt!!.defaultFormat(),
                r.updatedAt!!.defaultFormat(),
                r.reviewItems!!.map { ReviewItemResponse.from(it) }
            )
    }
}