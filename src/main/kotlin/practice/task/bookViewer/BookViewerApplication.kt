package practice.task.bookViewer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookViewerApplication

fun main(args: Array<String>) {
	runApplication<BookViewerApplication>(*args)
}
