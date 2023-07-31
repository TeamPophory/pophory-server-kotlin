package com.pophory.pophoryapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.pophory.pophoryapi", "com.pophory.pophorydomain"])
@EntityScan(basePackages = ["com.pophory.pophorydomain"])
@EnableJpaRepositories(basePackages = ["com.pophory.pophorydomain", "com.pophory.pophoryapi"])
class PophoryApiApplication

fun main(args: Array<String>) {
    runApplication<PophoryApiApplication>(*args)
}