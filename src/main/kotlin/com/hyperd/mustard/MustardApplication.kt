package com.hyperd.mustard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MustardApplication

fun main(args: Array<String>) {
	runApplication<MustardApplication>(*args)
}
