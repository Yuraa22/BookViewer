package practice.task.bookViewer.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import practice.task.bookViewer.db.BookRepository

@Controller
class ViewBooksController(private val repository: BookRepository) {

    @GetMapping("/")
    fun viewBooks(model: Model): String{
        model["title"] = "Book Viewer Application"
        model["books"] = repository.findAll()
        return "viewbooks"
    }
}
