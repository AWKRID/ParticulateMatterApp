package com.awkrid.particulatematter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class ParticulateMatterApplication

fun main(args: Array<String>) {
    runApplication<ParticulateMatterApplication>(*args)
}
