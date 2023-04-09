package com.kdh.tmp.service

import com.kdh.tmp.domain.review.ReviewRepository
import com.kdh.tmp.dto.review.ReviewListResponse
import com.kdh.tmp.dto.review.ReviewResponse
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.springframework.stereotype.Service

@Service
class ReviewSearchService(val repository: ReviewRepository) {
    fun searchById(reviewId: Long): ReviewResponse =
        ReviewResponse.from(repository.findById(reviewId)
            .orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) })

    fun searchByReviewer(reviewerId: Long): ReviewListResponse =
        ReviewListResponse(
            repository.findByReviewerId(reviewerId)
                .map { ReviewResponse.from(it) }
        )

}