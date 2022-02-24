package com.kdh.tmp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class TmpApplication

fun main(args: Array<String>) {
    runApplication<TmpApplication>(*args)
}
