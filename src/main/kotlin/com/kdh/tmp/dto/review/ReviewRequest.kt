package com.kdh.tmp.dto.review

import com.kdh.tmp.domain.review.Review

data class ReviewRequest(
    val reviewerId: Long,
    val revieweeId: Long,
    val comment: String,
    val metaReviewContents: List<Long>
) {
    fun createReview(): Review =
        Review().also {
            it.createReviewItems(metaReviewContents)

            it.reviewerId = this.reviewerId
            it.revieweeId = this.revieweeId
            it.comment = this.comment
        }

//    fun updateReview(entity: Review): Review =
//        entity.also {
//            it.createReviewItems(metaReviewContents)
//
//            it.reviewerId = this.reviewerId
//            it.revieweeId = this.revieweeId
//            it.comment = this.comment
//        }
}
