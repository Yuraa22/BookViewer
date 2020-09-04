package practice.task.bookViewer

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

@Controller
class ReadBookController (private val bookRepository: BookRepository, private val authorRepository: AuthorRepository) {

    @GetMapping("/readbook")
    fun addBook(model: Model): String {
        model.addAttribute("title", "Book Viewer App - Read Book")
        return "readbook"
    }

    @PostMapping("/readbook")
    fun uploadMultipartFile(@RequestParam("uploadfile") file: MultipartFile, @RequestParam("isbn") isbn: String, model: Model): String {
        model.addAttribute("title", "Book Viewer App - Read Book")
        return "readbook"
    }
}

