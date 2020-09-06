package practice.task.bookViewer.db

import org.springframework.data.repository.CrudRepository
import practice.task.bookViewer.db.Author
import practice.task.bookViewer.db.Book
import practice.task.bookViewer.db.Page

interface BookRepository: CrudRepository<Book, String>{
    fun findByIsbn(isbn: String): Book?
}

interface AuthorRepository: CrudRepository<Author, String>{
    fun findByUsername(username: String): Author?
}

interface PageRepository: CrudRepository<Page, String>{
    fun findByIsbnAndNumber(isbn: String, number: Int): Page?
    fun findAllByIsbn(isbn: String): Iterable<Page>
}
