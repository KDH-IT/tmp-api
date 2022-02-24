package com.kdh.tmp.domain.review

import com.querydsl.jpa.impl.JPAQueryFactory

class ReviewRepositoryImpl(val queryFactory: JPAQueryFactory) : ReviewRepositoryCustom {
    override fun findByReviewerId(reviewerId: Long): List<Review> {
        val review = QReview.review
        val reviewItem = QReviewItem.reviewItem
        val content = QMetaReviewContent.metaReviewContent

        return queryFactory
            .select(review)
            .from(review)
            .leftJoin(review.reviewItems, reviewItem).fetchJoin()
            .leftJoin(reviewItem.metaReviewContent, content).fetchJoin()
            .where(review.reviewerId.eq(reviewerId))
            .distinct()
            .fetch()
    }
}