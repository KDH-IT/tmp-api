package com.kdh.tmp.domain.review

import org.springframework.data.jpa.repository.JpaRepository

interface ReviewItemRepository : JpaRepository<ReviewItem, Long> {
}