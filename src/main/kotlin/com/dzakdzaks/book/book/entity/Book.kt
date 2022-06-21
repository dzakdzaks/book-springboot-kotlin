package com.dzakdzaks.book.book.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.newId
import java.util.*

data class Book(
    @BsonId
    var id: String = newId<Book>().toString(),
    var title: String,
    var createdDate: Date = Date(),
    var updatedDate: Date = Date()

)