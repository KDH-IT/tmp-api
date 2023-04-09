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
class Review() {

    constructor(reviewer: User, reviewee: User, reviewComment: String) : this() {
        this.reviewer = reviewer
        this.reviewee = reviewee
        this.reviewComment = reviewComment
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var reviewId: Long? = null
    var reviewComment: String? = null

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "reviewerId", insertable = true, updatable = false, nullable = false)
    var reviewer: User? = null

    @ManyToOne
    @JoinColumn(name = "revieweeId", insertable = true, updatable = false, nullable = false)
    var reviewee: User? = null

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "review")
    var reviewItems: List<ReviewItem>? = null

}