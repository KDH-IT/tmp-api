package com.kdh.tmp.domain.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ItemPostRepository : JpaRepository<ItemPost, Long> {
    @Query("""select item, seller, buyer from ItemPost item
                left outer join User seller
                on item.seller.userId = seller.userId
                left outer join User buyer
                on item.buyer.userId = buyer.userId
                where item.seller.userId=:sellerId""")
    fun findBySellerId(sellerId: Long): List<ItemPost>

    @Query("""select item, seller, buyer from ItemPost item
                left outer join User seller
                on item.seller.userId = seller.userId
                left outer join User buyer
                on item.buyer.userId = buyer.userId
                where item.buyer.userId=:buyerId""")
    fun findByBuyerId(buyerId: Long): List<ItemPost>

}