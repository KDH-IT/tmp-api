package com.kdh.tmp.domain.review

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewItemRepository : JpaRepository<ReviewItem, Long> {
    // TODO(테이블 인덱스 추가)
    fun findByReviewId(reviewId: Long): List<ReviewItem>
}