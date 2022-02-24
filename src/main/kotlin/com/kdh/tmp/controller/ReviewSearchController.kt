package com.kdh.tmp.controller

import com.kdh.tmp.aop.ApiLogging
import com.kdh.tmp.dto.review.ReviewListResponse
import com.kdh.tmp.dto.review.ReviewResponse
import com.kdh.tmp.service.ReviewSearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewSearchController(val searchService: ReviewSearchService) {

    @ApiLogging
    @GetMapping("/api/v1/review/{review_id}")
    fun searchDetailReviewById(@PathVariable("review_id") reviewId: Long): ReviewResponse =
        searchService.searchById(reviewId)

    @ApiLogging
    @GetMapping("/api/v1/user/{reviewer_id}/review")
    fun searchReviewByReviewerId(@PathVariable("reviewer_id") reviewerId: Long): ReviewListResponse =
        searchService.searchByReviewer(reviewerId)
}