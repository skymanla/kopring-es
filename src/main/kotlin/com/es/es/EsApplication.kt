package com.es.es

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class EsApplication

fun main(args: Array<String>) {
    runApplication<EsApplication>(*args)
}
