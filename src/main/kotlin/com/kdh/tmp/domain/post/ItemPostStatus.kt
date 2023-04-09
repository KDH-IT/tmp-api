package com.kdh.tmp.domain.post

enum class ItemPostStatus(val phrase: String) {
    ON_SALE("판매중"),
    BOOKING("예약중"),
    SOLD_OUT("판매완료")
}