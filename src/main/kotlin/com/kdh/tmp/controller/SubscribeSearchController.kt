package com.kdh.tmp.controller

import com.kdh.tmp.aop.ApiLogging
import com.kdh.tmp.dto.post.SubscribeResponse
import com.kdh.tmp.dto.post.SubscribeListResponse
import com.kdh.tmp.service.SubscribeSearchService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SubscribeSearchController(val searchService: SubscribeSearchService) {
    @ApiLogging
    @GetMapping("/api/v1/subscribe/{subscribe_id}")
    fun searchDetailSubscribeById(@PathVariable("subscribe_id") subscribeId: Long): SubscribeResponse =
        searchService.searchById(subscribeId)

    @ApiLogging
    @GetMapping("/api/v1/user/{user_id}/subscribe")
    fun searchSubscribeByUserId(@PathVariable("user_id") subscriberId: Long): SubscribeListResponse =
        searchService.searchBySubscriber(subscriberId)

    @ApiLogging
    @GetMapping("/api/v1/item-post/{post_id}/subscribe")
    fun searchSubscribeByPostId(@PathVariable("post_id") postId: Long): SubscribeListResponse =
        searchService.searchByItemPost(postId)
}