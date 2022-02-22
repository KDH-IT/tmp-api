package com.kdh.tmp.controller

import com.kdh.tmp.domain.review.MetaReviewContent
import com.kdh.tmp.domain.review.MetaReviewContentRepository
import com.kdh.tmp.dto.review.MetaReviewContentListResponse
import com.kdh.tmp.dto.review.MetaReviewContentRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

@RestController
class MetaReviewContentController(val metaReviewContentRepository: MetaReviewContentRepository) {

    val log: Logger = LoggerFactory.getLogger(MetaReviewContentController::class.java)

    @GetMapping("/api/meta/review-content/{content_id}")
    fun getMetaReviewContent(
        @PathVariable("content_id") contentId: Long
    ): MetaReviewContent {
        return metaReviewContentRepository.findById(contentId)
            .orElseThrow { ApiException(ErrorCode.CONTENT_NOT_FOUND) }
    }

    @PostMapping("/api/meta/review-content")
    fun createMetaReviewContent(
        @RequestBody requestBody: MetaReviewContentRequest
    ): MetaReviewContent {
        return metaReviewContentRepository.save(requestBody.createMetaReviewContent())
    }

    @PutMapping("/api/meta/review-content/{content_id}")
    fun updateMetaReviewContent(
        @RequestBody requestBody: MetaReviewContentRequest,
        @PathVariable("content_id") contentId: Long
    ): MetaReviewContent {
        return metaReviewContentRepository.findById(contentId)
            .orElseThrow { ApiException(ErrorCode.CONTENT_NOT_FOUND) }
            .also {
                requestBody.updateMetaReviewContent(it)
            }
    }

    @DeleteMapping("/api/meta/review-content/{content_id}")
    fun deleteMetaReviewContent(
        @PathVariable("content_id") contentId: Long
    ) {
        try {
            metaReviewContentRepository.deleteById(contentId)
        } catch (ignored: EmptyResultDataAccessException) {
            // do nothing
        }
    }

    @GetMapping("/api/meta/review-content")
    fun getMetaReviewContent(): MetaReviewContentListResponse {
        return MetaReviewContentListResponse(metaReviewContentRepository.findAll());
    }
}