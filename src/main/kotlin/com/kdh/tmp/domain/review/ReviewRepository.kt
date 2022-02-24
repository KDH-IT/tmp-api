package com.kdh.tmp.domain.review

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long>, ReviewRepositoryCustom {
}