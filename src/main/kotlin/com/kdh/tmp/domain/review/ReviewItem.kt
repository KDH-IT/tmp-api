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
class ReviewItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var reviewItemId: Long? = null

    var metaReviewContentId: Long? = null

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null

    @ManyToOne(targetEntity = Review::class)
    @JoinColumn(
        name = "reviewId",
        columnDefinition = "review_id",
        nullable = false,
        updatable = false,
        insertable = true
    )
    @JsonIgnore
    var review: Review? = null

    @ManyToOne(targetEntity = MetaReviewContent::class)
    @JoinColumn(name = "metaReviewContentId", nullable = false, updatable = false, insertable = false)
    var metaReviewContent: MetaReviewContent? = null
}