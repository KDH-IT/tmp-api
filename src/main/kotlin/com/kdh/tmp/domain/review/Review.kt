package com.kdh.tmp.domain.review

import com.kdh.tmp.domain.user.User
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

    @ManyToOne(targetEntity = User::class)
    @JoinColumn(name = "revieweeId", nullable = false, updatable = false, insertable = false)
    var reviewee: User? = null

    @ManyToOne(targetEntity = User::class)
    @JoinColumn(name = "reviewerId", nullable = false, updatable = false, insertable = false)
    var reviewer: User? = null

    @OneToMany(targetEntity = ReviewItem::class, fetch = FetchType.EAGER, mappedBy = "reviewId")
    var reviewItems: List<ReviewItem> = ArrayList()

    fun createReviewItems(metaReviewContents: List<Long>) {
        reviewItems = ArrayList()
        metaReviewContents.forEach(this::addReviewItem)
    }

    fun addReviewItem(metaReviewContentId: Long) {
        val reviewItem = ReviewItem().also {
            it.metaReviewContentId = metaReviewContentId
            it.reviewId = this.reviewId
        }
        reviewItems = reviewItems + reviewItem
    }
}