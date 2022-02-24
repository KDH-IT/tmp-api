package com.kdh.tmp.domain.review

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MetaReviewItemRepository : JpaRepository<MetaReviewItem, Long> {

    fun findAllByMetaReviewItemIdIsIn(ids: List<Long>): List<MetaReviewItem>
}