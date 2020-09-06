package practice.task.bookViewer.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import practice.task.bookViewer.db.AuthorRepository
import practice.task.bookViewer.utility.JwtTokenUtil.generateToken

@Controller
class LoginController (private val authorRepository: AuthorRepository) {

    @GetMapping("/login")
    fun addBook(model: Model): String {
        model["title"] = "Book Viewer Application - Login"
        return "login"
    }

    @PostMapping("/login")
    fun uploadMultipartFile(@RequestParam("username") username: String,
                            @RequestParam("password") password: String,
                            model: Model): String {
        model["title"] = "Book Viewer Application - Login"
        var author = authorRepository.findByUsername(username)
        if (author != null) {
            if (author.password == password) {
                model["message"] = "JWT: " + generateToken(username)
            } else {
                model["message"] = "Credentials not valid."
            }
        }
        return "login"
    }
}