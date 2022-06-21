package com.dzakdzaks.book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookApplication

fun main(args: Array<String>) {
	runApplication<BookApplication>(*args)
}
