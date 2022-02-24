package com.kdh.tmp.domain.review

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ReviewItemRepository : JpaRepository<ReviewItem, Long> {
    @EntityGraph(attributePaths = ["review", "metaReviewContent"])
    @Query("select item from ReviewItem item where item.review.reviewId=:reviewId")
    fun findByReviewId(reviewId: Long): List<ReviewItem>
}