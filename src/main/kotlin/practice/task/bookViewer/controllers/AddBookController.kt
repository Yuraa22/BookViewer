package practice.task.bookViewer.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import practice.task.bookViewer.db.*
import practice.task.bookViewer.utility.JwtTokenUtil.validateToken
import practice.task.bookViewer.utility.IsbnUtil.checkIsbn
import practice.task.bookViewer.utility.PdfParser
import java.io.BufferedInputStream

import java.io.InputStream

@Controller
class AddBookController (private val bookRepository: BookRepository,
                         private val authorRepository: AuthorRepository,
                         private val pageRepository: PageRepository) {

    @GetMapping("/addbook")
    fun addBook(model: Model,
                @RequestHeader("authorization") token: String?): String {
        var author: Author? = validateToken(token, authorRepository) ?: return "redirect:/login"
        model["title"] = "Book Viewer Application - Add Book"
        return "addbook"
    }

    @PostMapping("/addbook")
    fun uploadMultipartFile(@RequestParam("uploadfile") file: MultipartFile,
                            @RequestParam("isbn") isbn: String,
                            model: Model,
                            @RequestHeader("authorization") token: String?): String {
        var author: Author? = validateToken(token, authorRepository) ?: return "redirect:/login"
        model["title"] = "Book Viewer Application - Add Book"
        if (checkIsbn(isbn)) {
            model["message"] = "File " + isbn + " uploaded successfully! -> filename = " + file.originalFilename

            val bvUser = authorRepository.findByUsername("bvUser")

            val inputStream: InputStream = BufferedInputStream(file.inputStream)
            var pages = PdfParser.parse(inputStream, file.originalFilename, isbn, pageRepository)

            //for (page in pages) {
            //    pageRepository.save(page)
            //}

            bookRepository.save(Book(
                    isbn = isbn,
                    title = file.originalFilename,
                    processed = true,
                    pages = pages,
                    author = bvUser))
        }
        else
            model["message"] = "ISBN number is not in correct format."
        return "addbook"
    }

}

