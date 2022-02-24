package com.kdh.tmp.controller

import com.kdh.tmp.aop.ApiLogging
import com.kdh.tmp.dto.post.ItemPostDetailResponse
import com.kdh.tmp.dto.post.ItemPostListResponse
import com.kdh.tmp.service.ItemPostSearchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemPostSearchController(val searchService: ItemPostSearchService) {

    @ApiLogging
    @GetMapping("/api/v1/item-post/{post_id}")
    fun searchDetailItemPostById(@PathVariable("post_id") itemPostId: Long): ItemPostDetailResponse =
        searchService.searchById(itemPostId)

    @ApiLogging
    @GetMapping("/api/v1/seller/{seller_id}/item-post")
    fun searchItemPostsBySellerId(@PathVariable("seller_id") userId: Long): ItemPostListResponse =
        searchService.searchBySeller(userId)

    @ApiLogging
    @GetMapping("/api/v1/buyer/{buyer_id}/item-post")
    fun searchItemPostsByBuyerId(@PathVariable("buyer_id") userId: Long): ItemPostListResponse =
        searchService.searchByBuyer(userId)
}