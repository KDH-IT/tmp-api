package com.kdh.tmp.controller.crud

import com.kdh.tmp.domain.post.ItemPost
import com.kdh.tmp.domain.post.ItemPostRepository
import com.kdh.tmp.dto.post.ItemPostRequest
import com.kdh.tmp.exception.ApiException
import com.kdh.tmp.exception.ErrorCode
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
class ItemPostCrudController(val itemPostRepository: ItemPostRepository) {

    @GetMapping("/api/item-post/{post_id}")
    fun getItemPost(@PathVariable("post_id") postId: Long): ItemPost =
        itemPostRepository.findById(postId).orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) }

    @Transactional
    @PostMapping("/api/item-post")
    fun createItemPost(@RequestBody requestBody: ItemPostRequest): ItemPost =
        itemPostRepository.save(requestBody.createItemPost())

    @PutMapping("/api/item-post/{post_id}")
    fun updateItemPost(
        @RequestBody requestBody: ItemPostRequest,
        @PathVariable("post_id") postId: Long
    ): ItemPost =
        itemPostRepository.findById(postId)
            .orElseThrow { ApiException(ErrorCode.DATA_NOT_FOUND) }
            .also {
                requestBody.copyToEntity(it)
            }

    @DeleteMapping("/api/item-post/{post_id}")
    fun deleteItemPost(@PathVariable("post_id") postId: Long) {
        try {
            itemPostRepository.deleteById(postId)
        } catch (ignored: EmptyResultDataAccessException) {
            // do nothing
        }
    }

}