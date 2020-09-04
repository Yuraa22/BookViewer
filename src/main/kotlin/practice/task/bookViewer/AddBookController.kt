package practice.task.bookViewer

import org.apache.pdfbox.pdfparser.PDFParser
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import practice.task.bookViewer.Utility.checkIsbn
import java.io.BufferedInputStream

import java.io.InputStream

@Controller
class AddBookController (private val bookRepository: BookRepository, private val authorRepository: AuthorRepository) {

    @GetMapping("/addbook")
    fun addBook(model: Model): String {
        model.addAttribute("title", "Book Viewer App - Add Book")
        return "addbook"
    }

    @PostMapping("/addbook")
    fun uploadMultipartFile(@RequestParam("uploadfile") file: MultipartFile, @RequestParam("isbn") isbn: String, model: Model): String {
        model.addAttribute("title", "Book Viewer App - Add Book")
        if (checkIsbn(isbn)) {
            model.addAttribute("message", "File " + isbn + " uploaded successfully! -> filename = " + file.originalFilename)

            val bvUser = authorRepository.findByUsername("bvUser")

            val inputStream: InputStream = BufferedInputStream(file.inputStream)
            var pages = PdfParser.parse(inputStream, file.originalFilename, isbn)

            bookRepository.save(Book(
                    isbn = isbn,
                    title = file.originalFilename,
                    processed = false,
                    pages = pages,
                    author = bvUser))
        }
        else
            model.addAttribute("message", "ISBN number is not in correct format.")
        return "addbook"
    }

}

