package com.kdh.tmp.domain.review

import com.kdh.tmp.common.Yn
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "meta_review_items")
class MetaReviewItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var metaReviewItemId: Long? = null

    @Column(length = 50)
    var shortReview: String? = null

    @Enumerated(EnumType.STRING)
    var positiveYn: Yn? = null

    var updatedBy: String? = null

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null
}