package com.kdh.tmp.domain.review

import com.kdh.tmp.domain.user.QUser
import com.querydsl.jpa.impl.JPAQueryFactory

class ReviewRepositoryImpl(private val queryFactory: JPAQueryFactory) : ReviewRepositoryCustom {
    override fun findByReviewerId(reviewerId: Long): List<Review> {
        val review = QReview.review
        val reviewItem = QReviewItem.reviewItem
        val content = QMetaReviewItem.metaReviewItem
        val user = QUser.user

        return queryFactory
            .select(review)
            .from(review)
            .leftJoin(review.reviewItems, reviewItem).fetchJoin()
            .leftJoin(reviewItem.meta, content).fetchJoin()
            .innerJoin(review.reviewer, user).fetchJoin()
            .innerJoin(review.reviewee, user).fetchJoin()
            .where(review.reviewer.userId.eq(reviewerId))
            .distinct()
            .fetch()
    }
}