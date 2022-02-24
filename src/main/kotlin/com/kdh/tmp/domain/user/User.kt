package com.kdh.tmp.domain.user

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener::class)
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var userId: Long? = null

    @Column(length = 12)
    open var phoneNumber: String? = null

    open var mannerTemperature: Int? = 365

    @LastModifiedDate
    open var updatedAt: LocalDateTime? = null

    @CreatedDate
    open var createdAt: LocalDateTime? = null
}