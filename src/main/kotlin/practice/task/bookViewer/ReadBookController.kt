package practice.task.bookViewer

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

@Controller
class ReadBookController (private val bookRepository: BookRepository, private val authorRepository: AuthorRepository, private val pageRepository: PageRepository) {

    @GetMapping("/readbook/{isbn}")
    fun addBook(model: Model, @PathVariable("isbn") isbn: String): String {
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

