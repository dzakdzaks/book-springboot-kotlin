package com.dzakdzaks.book.book.repository

import com.dzakdzaks.book.book.entity.Book

interface BookRepository {
    fun getBookById(id: String): Pair<Book?, String>
    fun getBooks(): Pair<List<Book>, String>
    fun addBook(book: Book): Pair<Book?, String>
    fun updateBook(id: String, book: Book): Pair<Book?, String>
    fun deleteBook(id: String): Pair<Book?, String>
}