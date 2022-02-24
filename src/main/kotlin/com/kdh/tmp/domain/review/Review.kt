package com.kdh.tmp.domain.review

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "reviews")
class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var reviewId: Long? = null
    var revieweeId: Long? = null
    var reviewerId: Long? = null
    var comment: String? = null

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null


    @OneToMany(targetEntity = ReviewItem::class, fetch = FetchType.EAGER, mappedBy = "review")
    var reviewItems: List<ReviewItem> = ArrayList()

    fun setReviewItemsFrom(metaReviewContents: List<Long>) {
        reviewItems = ArrayList()
        metaReviewContents.forEach(this::addReviewItem)
    }

    private fun addReviewItem(metaReviewContentId: Long) {
        reviewItems = reviewItems + ReviewItem().also {
            it.metaReviewContent = MetaReviewContent().also { content -> content.metaReviewContentId = metaReviewContentId }
            it.review = this
        }
    }
}