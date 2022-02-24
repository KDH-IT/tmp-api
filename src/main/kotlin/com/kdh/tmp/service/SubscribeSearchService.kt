package com.kdh.tmp.service

import com.kdh.tmp.domain.post.SubscribeRepository
import com.kdh.tmp.dto.post.SubscribeResponse
import com.kdh.tmp.dto.post.SubscribeListResponse
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.springframework.stereotype.Service

@Service
class SubscribeSearchService(val repository: SubscribeRepository) {
    fun searchById(subscribeId: Long): SubscribeResponse =
        SubscribeResponse.from(
            repository.findById(subscribeId).orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) })

    fun searchBySubscriber(subscriberId: Long): SubscribeListResponse =
        SubscribeListResponse(
            repository.findBySubscriberId(subscriberId)
                .map { SubscribeResponse.from(it) }
        )

    fun searchByItemPost(postId: Long): SubscribeListResponse =
        SubscribeListResponse(
            repository.findByItemPostId(postId)
                .map { SubscribeResponse.from(it) }
        )

}
