package com.kdh.tmp.service

import com.kdh.tmp.domain.post.ItemPostRepository
import com.kdh.tmp.dto.post.ItemPostBrief
import com.kdh.tmp.dto.post.ItemPostDetailResponse
import com.kdh.tmp.dto.post.ItemPostListResponse
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.springframework.stereotype.Service

@Service
class ItemPostSearchService(val repository: ItemPostRepository) {

    fun searchById(postId: Long): ItemPostDetailResponse =
        ItemPostDetailResponse.from(repository.findById(postId)
            .orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) })

    fun searchBySeller(sellerId: Long): ItemPostListResponse =
        ItemPostListResponse(repository.findBySellerId(sellerId)
            .map { ItemPostBrief.from(it) })

    fun searchByBuyer(buyerId: Long): ItemPostListResponse =
        ItemPostListResponse(repository.findByBuyerId(buyerId)
            .map { ItemPostBrief.from(it) })
}
