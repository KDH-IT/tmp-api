package com.kdh.tmp.controller.crud

import com.kdh.tmp.domain.review.Review
import com.kdh.tmp.domain.review.ReviewRepository
import com.kdh.tmp.dto.review.ReviewListResponse
import com.kdh.tmp.dto.review.ReviewRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import com.kdh.tmp.service.CreateReviewService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
class ReviewController(
    val reviewRepository: ReviewRepository,
    val createReviewService: CreateReviewService
) {

    val log: Logger = LoggerFactory.getLogger(ReviewController::class.java)

    @GetMapping("/api/review/{review_id}")
    fun getReview(@PathVariable("review_id") reviewId: Long): Review =
        reviewRepository.findById(reviewId).orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) }

    @Transactional
    @PostMapping("/api/review")
    fun createReview(@RequestBody request: ReviewRequest): Review =
        createReviewService.createReview(request)

    @DeleteMapping("/api/review/{review_id}")
    fun deleteReview(@PathVariable("review_id") reviewId: Long) {
        try {
            reviewRepository.deleteById(reviewId)
        } catch (ignored: EmptyResultDataAccessException) {
            // do nothing
        }
    }

    @GetMapping("/api/user/{user_id}/review")
    fun getAllReviewsByReviewerId(@PathVariable("user_id") userId: Long): ReviewListResponse =
        ReviewListResponse(reviewRepository.findByReviewerId(userId))
}