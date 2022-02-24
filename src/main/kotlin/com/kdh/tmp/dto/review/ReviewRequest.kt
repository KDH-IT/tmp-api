package com.kdh.tmp.dto.review

data class ReviewRequest(
    val reviewerId: Long,
    val revieweeId: Long,
    val comment: String,
    val metaReviewItemList: List<Long>
)
