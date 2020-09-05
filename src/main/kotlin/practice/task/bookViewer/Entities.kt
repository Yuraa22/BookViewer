package practice.task.bookViewer

import javax.persistence.*

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
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val page_id : Long = 0,
        var isbn: String,
        var number: Int,
        @Column(length = 500) var url: String)

