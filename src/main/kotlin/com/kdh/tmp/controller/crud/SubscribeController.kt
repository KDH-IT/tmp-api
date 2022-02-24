package com.kdh.tmp.controller.crud

import com.kdh.tmp.domain.post.Subscribe
import com.kdh.tmp.domain.post.SubscribeRepository
import com.kdh.tmp.dto.post.SubscribeListResponse
import com.kdh.tmp.dto.post.SubscribeRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

@RestController
class SubscribeController(val subscribeRepository: SubscribeRepository) {

    val log: Logger = LoggerFactory.getLogger(SubscribeController::class.java)

    @GetMapping("/api/subscribe/{subscribe_id}")
    fun getSubscribe(@PathVariable("subscribe_id") subscribeId: Long): Subscribe =
        subscribeRepository.findById(subscribeId).orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) }

    @PostMapping("/api/subscribe")
    fun createSubscribe(@RequestBody requestBody: SubscribeRequest): Subscribe =
        subscribeRepository.save(requestBody.createSubscribe())

    @DeleteMapping("/api/subscribe/{subscribe_id}")
    fun deleteSubscribe(@PathVariable("subscribe_id") subscribeId: Long) {
        try {
            subscribeRepository.deleteById(subscribeId)
        } catch (ignored: EmptyResultDataAccessException) {
            // do nothing
        }
    }

    @GetMapping("/api/item-post/{item_post_id}/subscribe")
    fun getSubscribeByItemPostId(@PathVariable("item_post_id") itemPostId: Long): SubscribeListResponse =
        SubscribeListResponse(subscribeRepository.findByItemPostId(itemPostId))

    @GetMapping("/api/user/{user_id}/subscribe")
    fun getAllSubscribesByUserId(@PathVariable("user_id") subscriberId: Long) =
        SubscribeListResponse(subscribeRepository.findBySubscriberId(subscriberId))
}