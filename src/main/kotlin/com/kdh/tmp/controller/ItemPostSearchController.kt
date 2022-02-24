package com.kdh.tmp.controller

import com.kdh.tmp.dto.post.ItemPostDetailResponse
import com.kdh.tmp.dto.post.ItemPostListResponse
import com.kdh.tmp.service.ItemPostSearchService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemPostSearchController(val searchService: ItemPostSearchService) {
    // TODO(logging by aop)
    private val log = LoggerFactory.getLogger(ItemPostSearchController::class.java)

    @GetMapping("/api/v1/item-post/{post_id}")
    fun searchDetailItemPostById(@PathVariable("post_id") itemPostId: Long): ItemPostDetailResponse {
        log.info("search by id:{}", itemPostId)
        val result = searchService.searchById(itemPostId)
        log.info("result: {}", result)
        return result
    }

    @GetMapping("/api/v1/seller/{seller_id}/item-post")
    fun searchItemPostsBySellerId(@PathVariable("seller_id") userId: Long): ItemPostListResponse {
        log.info("search by seller:{}", userId)
        val result = searchService.searchBySeller(userId)
        log.info("result: {}", result)
        return result
    }

    @GetMapping("/api/v1/buyer/{buyer_id}/item-post")
    fun searchItemPostsByBuyerId(@PathVariable("buyer_id") userId: Long): ItemPostListResponse {
        log.info("search by buyer:{}", userId)
        val result = searchService.searchByBuyer(userId)
        log.info("result: {}", result)
        return result
    }
}