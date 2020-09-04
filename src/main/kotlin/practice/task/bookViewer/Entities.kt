package practice.task.bookViewer

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name= "Author")
class Author(
        @Id var username: String,
        var password: String)

@Entity
@Table(name= "Book")
class Book(
        @Id var isbn: String,
        @ManyToOne var author: Author?,
        var processed: Boolean,
        var pages: Int,
        var title: String?)

@Entity
@Table(name= "Page")
class Page(
        @Id var isbn: String,
        var number: Int,
        var url: String)

