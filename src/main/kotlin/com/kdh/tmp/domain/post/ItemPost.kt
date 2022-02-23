package com.kdh.tmp.domain.post

import com.kdh.tmp.domain.user.User
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "item_posts")
@EntityListeners(AuditingEntityListener::class)
class ItemPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var itemPostId: Long? = null

    @Enumerated(EnumType.STRING)
    var itemStatus: ItemPostStatus? = ItemPostStatus.ON_SALE

    var title: String? = null

    var content: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sellerId", insertable = true, updatable = false, nullable = false)
    var seller: User? = null

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "buyerId", insertable = true, updatable = true, nullable = true)
    var buyer: User? = null

    var itemImageUrl: String? = null

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null

    @CreatedDate
    var createdAt: LocalDateTime? = null

}