package com.kdh.tmp.domain.review

interface ReviewRepositoryCustom {
    fun findByReviewerId(reviewerId: Long): List<Review>
}