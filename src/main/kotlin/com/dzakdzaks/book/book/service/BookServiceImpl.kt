package com.dzakdzaks.book.book.service

import com.dzakdzaks.book.book.entity.Book
import com.dzakdzaks.book.book.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl: BookService {

    @Autowired
    private lateinit var bookRepository: BookRepository

    override fun getBookById(id: String): Pair<Book?, String> {
        return bookRepository.getBookById(id)
    }

    override fun getBooks(): Pair<List<Book>, String> {
        return bookRepository.getBooks()
    }

    override fun addBook(book: Book): Pair<Book?, String> {
        return bookRepository.addBook(book)
    }

    override fun updateBook(id: String, book: Book): Pair<Book?, String> {
        return bookRepository.updateBook(id, book)
    }

    override fun deleteBook(id: String): Pair<Book?, String> {
        return bookRepository.deleteBook(id)
    }
}