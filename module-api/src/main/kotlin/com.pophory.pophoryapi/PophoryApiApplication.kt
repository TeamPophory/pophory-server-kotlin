package com.pophory.pophoryapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.pophory.pophoryapi"])
class PophoryApiApplication

fun main(args: Array<String>) {
    runApplication<PophoryApiApplication>(*args)
}