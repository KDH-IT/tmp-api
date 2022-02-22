package com.kdh.tmp.dto.review

import com.kdh.tmp.domain.review.ReviewItem

data class ReviewItemRequest(
    val reviewId: Long,
    val metaReviewContentId: Long
) {
    fun createReviewItem(): ReviewItem =
        ReviewItem().also {
            it.reviewId = this.reviewId
            it.metaReviewContentId = this.metaReviewContentId
        }

//    fun updateReviewItem(entity: ReviewItem): ReviewItem =
//        entity.also {
//            it.reviewId = this.reviewId
//            it.metaReviewContentId = this.metaReviewContentId
//        }
}
