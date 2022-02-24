package com.kdh.tmp.controller.crud

import com.kdh.tmp.domain.review.MetaReviewItem
import com.kdh.tmp.domain.review.MetaReviewItemRepository
import com.kdh.tmp.dto.review.MetaReviewItemListResponse
import com.kdh.tmp.dto.review.MetaReviewItemRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

/**
 * 어드민에서 사용할 예정
 * 리뷰 선택 항목 메타데이터
 */
@RestController
class MetaReviewItemCrudController(val metaReviewItemRepository: MetaReviewItemRepository) {


    @GetMapping("/api/meta/review-item/{meta_id}")
    fun getMetaReviewContent(@PathVariable("meta_id") metaId: Long): MetaReviewItem =
        metaReviewItemRepository.findById(metaId).orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) }

    @PostMapping("/api/meta/review-item")
    fun createMetaReviewContent(@RequestBody requestBody: MetaReviewItemRequest): MetaReviewItem =
        metaReviewItemRepository.save(requestBody.createMetaReviewContent())

    @PutMapping("/api/meta/review-item/{meta_id}")
    fun updateMetaReviewContent(
        @RequestBody requestBody: MetaReviewItemRequest,
        @PathVariable("meta_id") metaId: Long
    ): MetaReviewItem =
        metaReviewItemRepository.findById(metaId)
            .orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) }
            .also { requestBody.copyTo(it) }

    @DeleteMapping("/api/meta/review-item/{meta_id}")
    fun deleteMetaReviewContent(@PathVariable("meta_id") metaId: Long) {
        try {
            metaReviewItemRepository.deleteById(metaId)
        } catch (ignored: EmptyResultDataAccessException) {
            // do nothing
        }
    }

    @GetMapping("/api/meta/review-item")
    fun getMetaReviewContent(): MetaReviewItemListResponse =
        MetaReviewItemListResponse(metaReviewItemRepository.findAll())
}