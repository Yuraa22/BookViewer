package practice.task.bookViewer

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(bookRepository: BookRepository,
                            authorRepository: AuthorRepository) = ApplicationRunner {

        val bvUser = authorRepository.save(Author("bvUser", "bvUser"))

        bookRepository.save(Book(
                isbn = "978-0439064873",
                title = "Harry Potter and the Philosopher's Stone",
                processed = false,
                pages = 159,
                author = bvUser))

        bookRepository.save(Book(
                isbn = "9781408898109",
                title = "Harry Potter and the Chamber of Secrets",
                processed = false,
                pages = 255,
                author = bvUser))
    }
}