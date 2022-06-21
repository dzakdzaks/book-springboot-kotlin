package com.dzakdzaks.book.book.controller

import com.dzakdzaks.book.base.BaseResponse
import com.dzakdzaks.book.book.entity.Book
import com.dzakdzaks.book.book.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("v1/book")
class BookController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping("/{id}")
    fun getBookById(
        @PathVariable(name = "id") id: String
    ): BaseResponse<Book> {
        val result = bookService.getBookById(id = id)
        return if (result.first != null && result.second.isEmpty()) {
            BaseResponse(
                status = HttpStatus.OK.value(),
                message = "Get Book Success",
                data = result.first
            )
        } else {
            BaseResponse(
                status = HttpStatus.NOT_FOUND.value(),
                message = "Book Not Found",
                data = null
            )
        }
    }

    @GetMapping
    fun getBooks(): BaseResponse<List<Book>> {
        val result = bookService.getBooks()
        return BaseResponse(
            status = HttpStatus.OK.value(),
            message = "Get Books Success",
            data = result.first
        )
    }

    @PostMapping
    fun addBook(
        @RequestBody request: Book
    ): BaseResponse<Book> {
        val result = bookService.addBook(book = request)
        return if (result.first != null && result.second.isEmpty()) {
            BaseResponse(
                status = HttpStatus.OK.value(),
                message = "Add Book Success",
                data = result.first
            )
        } else {
            BaseResponse(
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message = "Add Book Failed : ${result.second}",
                data = result.first
            )
        }
    }

    @PutMapping("/{id}")
    fun updateBook(
        @PathVariable(name = "id") id: String,
        @RequestBody request: Book
    ): BaseResponse<Book> {
        val result = bookService.updateBook(id = id, book = request)
        return if (result.first != null && result.second.isEmpty()) {
            BaseResponse(
                status = HttpStatus.OK.value(),
                message = "Update Book Success",
                data = result.first
            )
        } else {
            BaseResponse(
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message = "Update Book Failed : ${result.second}",
                data = null
            )
        }
    }

    @DeleteMapping("/{id}")
    fun deleteBook(
        @PathVariable(name = "id") id: String
    ): BaseResponse<String> {
        val result = bookService.deleteBook(id = id)
        return if (result.first != null && result.second.isEmpty()) {
            BaseResponse(
                status = HttpStatus.OK.value(),
                message = "${result.first?.title} Deleted",
                data = null
            )
        } else {
            BaseResponse(
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                message = "Delete Book Failed : ${result.second}",
                data = null
            )
        }

    }

}