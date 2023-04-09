package com.kdh.tmp.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateTimeUtil {
    companion object {
        val defaultFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd mm:ss")

        fun toString(time: LocalDateTime): String =
            defaultFormatter.format(time)
    }
}

fun LocalDateTime.defaultFormat() =
    DateTimeUtil.toString(this)