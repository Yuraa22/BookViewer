package practice.task.bookViewer

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import practice.task.bookViewer.db.*

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(bookRepository: BookRepository,
                            authorRepository: AuthorRepository,
                            pageRepository: PageRepository) = ApplicationRunner {

        val bvUser = authorRepository.save(Author("bvUser", "bvUser"))
        val bvUser2 = authorRepository.save(Author("bvUser2", "bvUser2"))

//        bookRepository.save(Book(
//                isbn = "978-0439064873",
//                title = "Harry Potter and the Philosopher's Stone",
//                processed = false,
//                pages = 159,
//                author = bvUser))
//
//        bookRepository.save(Book(
//                isbn = "9781408898109",
//                title = "Harry Potter and the Chamber of Secrets",
//                processed = false,
//                pages = 255,
//                author = bvUser))

        bookRepository.save(Book(
                isbn = "9780545010221",
                title = "Shortest vector problem Ajtai",
                processed = true,
                pages = 10,
                author = bvUser))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 1,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_1.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115247Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=9531cf64a27028800a8659c94013ffcb6920d8dc274f2e7e693f927550658f74"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 2,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_2.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115251Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=3d3e492a7871cbf25c4a827d939a4f081265232756200b54115e34539c2f98a2"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 3,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_3.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115246Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=e4677d54b4ec9ea3be69b516e39f2a9c1406c2362977bcdbd6a82cb01735633a"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 4,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_4.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115246Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=d0b4a7b1f1886841e992574e8a462eb64ed6bda40cfb11d06ff5b8627498eaeb"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 5,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_5.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115254Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=568d1ff4c697a3c379d2ce3b704a180cd40b9043a4b62f7e9fada07e5312cdd2"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 6,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_6.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115254Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=13fa1cf4ad97c68949f66c10e71c53240d52bb4324cb693b407af61288398c62"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 7,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_7.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115247Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=a4f6d45b4150a9a8d76a5f714d5437171b557ff6d849b232552b4cd203e0fd72"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 8,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_8.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115246Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=57d13358132823b3b82013e07a21cc2ec566ac9addea398ad85df1ff72bf87f2"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 9,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_9.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115249Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=32bde69cba14cf11165ba3201edb8ec3556106b982b1e42d6e6848715536b5af"
        ))

        pageRepository.save(Page(
                isbn = "9780545010221",
                number = 10,
                url = "https://play.min.io/bv-app-bucket/Shortest%20vector%20problem_Ajtai.pdf_10.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=Q3AM3UQ867SPQQA43P2F%2F20200905%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200905T115249Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=9a38c0e4cbfcbd25a9a0b923c078d06d894e4383125fdc51832190daeb704e4f"
        ))
    }
}