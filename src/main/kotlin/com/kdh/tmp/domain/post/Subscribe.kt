package com.kdh.tmp.domain.post

import com.kdh.tmp.domain.user.User
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*


@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "subscribes")
class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var subscribeId : Long? = null

    @CreatedDate
    var createdAt : LocalDateTime? = null

    @LastModifiedDate
    var updatedAt : LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "subscriberId", updatable = false, nullable = false)
    var subscriber : User? = null

    @ManyToOne
    @JoinColumn(name = "itemPostId", updatable = false, nullable = false)
    var itemPost : ItemPost? = null
}