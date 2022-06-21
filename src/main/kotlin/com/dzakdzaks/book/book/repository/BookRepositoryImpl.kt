package com.dzakdzaks.book.book.repository

import com.dzakdzaks.book.book.entity.Book
import com.dzakdzaks.book.database.DatabaseComponent
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BookRepositoryImpl : BookRepository {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private val bookCollection: MongoCollection<Book> by lazy {
        databaseComponent.database.getCollection()
    }

    override fun getBookById(id: String): Pair<Book?, String> {
        return try {
            bookCollection.findOneById(id)?.let {
                it to ""
            } ?: kotlin.run {
                null to "Book Not Found"
            }
        } catch (e: Exception) {
            null to e.localizedMessage
        }
    }

    override fun getBooks(): Pair<List<Book>, String> {
        return try {
            bookCollection.find().toList() to ""
        } catch (e: Exception) {
            emptyList<Book>() to e.localizedMessage
        }
    }

    override fun addBook(book: Book): Pair<Book?, String> {
        return try {
            val insert = bookCollection.insertOne(book)
            return if (insert.wasAcknowledged()) {
                getBookById(book.id)
            } else {
                null to ""
            }
        } catch (e: Exception) {
            null to e.localizedMessage
        }
    }

    override fun updateBook(id: String, book: Book): Pair<Book?, String> {
        return try {
            val update = bookCollection.updateOne(
                Book::id eq id,
                set(Book::title setTo book.title, Book::updatedDate setTo Date())
            )
            if (update.wasAcknowledged()) {
                getBookById(id)
            } else {
                null to "Book Not Found"
            }
        } catch (e: Exception) {
            null to e.localizedMessage
        }

    }

    override fun deleteBook(id: String): Pair<Book?, String> {
        return try {
            val result = bookCollection.findOneAndDelete(Book::id eq id)
            if (result != null) {
                result to ""
            } else {
                null to "Book Not Found"
            }
        } catch (e: Exception) {
            null to e.localizedMessage
        }
    }
}