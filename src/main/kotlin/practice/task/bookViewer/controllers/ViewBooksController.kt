package practice.task.bookViewer.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import practice.task.bookViewer.db.Author
import practice.task.bookViewer.db.AuthorRepository
import practice.task.bookViewer.db.BookRepository
import practice.task.bookViewer.utility.Utility

@Controller
class ViewBooksController(private val bookRepository: BookRepository,
                          private val authorRepository: AuthorRepository) {

    @GetMapping("/")
    fun viewBooks(model: Model,
                  @RequestHeader("authorization") token: String?): String{
        var author: Author? = Utility.validateJWT(token, authorRepository) ?: return "redirect:/login"
        model["title"] = "Book Viewer Application"
        if (author != null) {
            model["books"] = bookRepository.findAllByAuthor(author.username)
        }
        return "viewbooks"
    }
}
