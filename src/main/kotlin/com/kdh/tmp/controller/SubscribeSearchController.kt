package com.kdh.tmp.controller

import com.kdh.tmp.dto.post.SubscribeResponse
import com.kdh.tmp.dto.post.SubscribeListResponse
import com.kdh.tmp.service.SubscribeSearchService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SubscribeSearchController(val searchService: SubscribeSearchService) {
    private val log = LoggerFactory.getLogger(SubscribeSearchController::class.java)

    @GetMapping("/api/v1/subscribe/{subscribe_id}")
    fun searchDetailSubscribeById(@PathVariable("subscribe_id") subscribeId: Long): SubscribeResponse {
        log.info("search by id: {}", subscribeId)
        val result = searchService.searchById(subscribeId)
        log.info("result: {}", result)
        return result
    }

    @GetMapping("/api/v1/user/{user_id}/subscribe")
    fun searchSubscribeByUserId(@PathVariable("user_id") subscriberId: Long): SubscribeListResponse {
        log.info("search by subscriber: {}", subscriberId)
        val result = searchService.searchBySubscriber(subscriberId)
        log.info("result: {}", result)
        return result
    }

    @GetMapping("/api/v1/item-post/{post_id}/subscribe")
    fun searchSubscribeByPostId(@PathVariable("post_id") postId: Long): SubscribeListResponse {
        log.info("search by item-post: {}", postId)
        val result = searchService.searchByItemPost(postId)
        log.info("result: {}", result)
        return result
    }
}