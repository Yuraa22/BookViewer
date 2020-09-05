package practice.task.bookViewer

import org.springframework.data.repository.CrudRepository

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
