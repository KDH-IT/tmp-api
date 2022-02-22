package com.kdh.tmp.controller

import com.kdh.tmp.domain.review.ReviewItem
import com.kdh.tmp.domain.review.ReviewItemRepository
import com.kdh.tmp.dto.review.ReviewItemListResponse
import com.kdh.tmp.dto.review.ReviewItemRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

@RestController
class ReviewItemController(val reviewItemRepository: ReviewItemRepository) {

    val log: Logger = LoggerFactory.getLogger(ReviewItemController::class.java)

    @GetMapping("/api/review-item/{item_id}")
    fun getReviewItem(
        @PathVariable("item_id") itemId: Long
    ): ReviewItem {
        return reviewItemRepository.findById(itemId)
            .orElseThrow { ApiException(ErrorCode.CONTENT_NOT_FOUND) }
    }

    @PostMapping("/api/review-item")
    fun createReviewItem(
        @RequestBody requestBody: ReviewItemRequest
    ): ReviewItem {
        return reviewItemRepository.save(requestBody.createReviewItem())
    }
    @DeleteMapping("/api/review-item/{item_id}")
    fun deleteReviewItem(
        @PathVariable("item_id") itemId: Long
    ) {
        try {
            reviewItemRepository.deleteById(itemId)
        } catch (ignored: EmptyResultDataAccessException) {
            // do nothing
        }
    }

    @GetMapping("/api/review/{review_id}")
    fun getReviewItemsByReview(
        @PathVariable("review_id") reviewId: Long
    ): ReviewItemListResponse {
        return ReviewItemListResponse(reviewItemRepository.findByReviewId(reviewId));
    }
}