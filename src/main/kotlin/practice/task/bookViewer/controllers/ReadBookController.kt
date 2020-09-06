package practice.task.bookViewer.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import practice.task.bookViewer.db.Author
import practice.task.bookViewer.db.AuthorRepository
import practice.task.bookViewer.db.BookRepository
import practice.task.bookViewer.db.PageRepository
import practice.task.bookViewer.utility.Utility

@Controller
class ReadBookController (private val bookRepository: BookRepository, private val authorRepository: AuthorRepository, private val pageRepository: PageRepository) {

    @GetMapping("/readbook/{isbn}")
    fun addBook(model: Model,
                @PathVariable("isbn") isbn: String,
                @RequestHeader("authorization") token: String?): String {
        var author: Author? = Utility.validateJWT(token, authorRepository) ?: return "redirect:/login"
        model["title"] = "Book Viewer App - Read Book"
        val book = bookRepository.findByIsbn(isbn)
        if (book != null) {
            model["book_title"] = book.title!!
        } else {
            model["book_title"] = ""
        }
        model["pages"] = pageRepository.findAllByIsbn(isbn)
        return "readbook"
    }
}

