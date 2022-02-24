package com.kdh.tmp.domain.post

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface SubscribeRepository : JpaRepository<Subscribe, Long> {
    @EntityGraph(attributePaths = ["user", "itemPost"])
    @Query("select s from Subscribe s where s.itemPost.itemPostId=:itemPostId")
    fun findByItemPostId(itemPostId: Long): List<Subscribe>
}