package com.kdh.tmp.controller

import com.kdh.tmp.dto.review.ReviewListResponse
import com.kdh.tmp.dto.review.ReviewResponse
import com.kdh.tmp.service.ReviewSearchService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewSearchController(val searchService: ReviewSearchService) {
    // TODO(logging by aop)
    private val log = LoggerFactory.getLogger(ReviewSearchController::class.java)

    @GetMapping("/api/v1/review/{review_id}")
    fun searchDetailReviewById(@PathVariable("review_id") reviewId: Long): ReviewResponse {
        log.info("search by id:{}", reviewId)
        val result = searchService.searchById(reviewId)
        log.info("result:{}", result)
        return result
    }

    @GetMapping("/api/v1/user/{reviewer_id}/review")
    fun searchReviewByReviewerId(@PathVariable("reviewer_id") reviewerId: Long): ReviewListResponse {
        log.info("search by reviewer:{}", reviewerId)
        val result = searchService.searchByReviewer(reviewerId)
        log.info("result:{}", result)
        return result
    }
}