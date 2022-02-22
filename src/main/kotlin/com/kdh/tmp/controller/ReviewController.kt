package com.kdh.tmp.controller

import com.kdh.tmp.domain.review.Review
import com.kdh.tmp.domain.review.ReviewRepository
import com.kdh.tmp.dto.review.ReviewItemRequest
import com.kdh.tmp.dto.review.ReviewListResponse
import com.kdh.tmp.dto.review.ReviewRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

@RestController
class ReviewController(val reviewRepository: ReviewRepository) {

    val log: Logger = LoggerFactory.getLogger(ReviewController::class.java)

    @GetMapping("/api/review/{review_id}")
    fun getReview(
        @PathVariable("review_id") reviewId: Long
    ): Review {
        return reviewRepository.findById(reviewId)
            .orElseThrow { ApiException(ErrorCode.CONTENT_NOT_FOUND) }
    }

    @PostMapping("/api/review")
    fun createReview(
        @RequestBody requestBody: ReviewRequest
    ): Review {
        return reviewRepository.save(requestBody.createReview())
    }

    @DeleteMapping("/api/review/{review_id}")
    fun deleteReview(
        @PathVariable("review_id") reviewId: Long
    ) {
        try {
            reviewRepository.deleteById(reviewId)
        } catch (ignored: EmptyResultDataAccessException) {
            // do nothing
        }
    }

    @GetMapping("/api/user/{user_id}/review")
    fun getAllReviewsByReviewerId(
        @PathVariable("user_id") userId: Long
    ): ReviewListResponse {
        return ReviewListResponse(reviewRepository.findByReviewerId(userId));
    }
}