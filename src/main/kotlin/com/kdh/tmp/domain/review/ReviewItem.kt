package com.kdh.tmp.domain.review

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "review_items")
@EntityListeners(AuditingEntityListener::class)
class ReviewItem() {

    constructor(review: Review, metaReviewItem: MetaReviewItem) : this() {
        this.review = review
        this.meta = metaReviewItem
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var reviewItemId: Long? = null

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "reviewId", updatable = false, insertable = true)
    @JsonIgnore
    var review: Review? = null

    @ManyToOne(targetEntity = MetaReviewItem::class, fetch = FetchType.EAGER)
    @JoinColumn(name = "metaReviewItemId", nullable = false, updatable = false, insertable = true)
    var meta: MetaReviewItem? = null

}