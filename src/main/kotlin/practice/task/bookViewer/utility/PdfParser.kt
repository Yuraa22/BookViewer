package practice.task.bookViewer.utility

import io.minio.*
import io.minio.http.Method
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.rendering.ImageType
import org.apache.pdfbox.rendering.PDFRenderer
import practice.task.bookViewer.db.Page
import practice.task.bookViewer.db.PageRepository
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.concurrent.TimeUnit
import javax.imageio.ImageIO

object PdfParser {

    fun parse(fis: InputStream, name: String?, isbn: String, pageRepository: PageRepository): Int {

        val document: PDDocument = PDDocument.load(fis)
        val pdfRenderer = PDFRenderer(document)

        for (page in 0 until document.numberOfPages) {
            GlobalScope.launch {
                val bImage = pdfRenderer.renderImageWithDPI(page, 300f, ImageType.RGB)
                val outputStream = ByteArrayOutputStream()
                ImageIO.write(bImage, "jpeg", outputStream)
                val inputStream: InputStream = ByteArrayInputStream(outputStream.toByteArray())
                val url = uploadToStorage(inputStream, name + "_" + (page + 1) + ".jpg")

                pageRepository.save(Page(
                        isbn = isbn,
                        number = page + 1,
                        url = url
                ))
            }
        }
        //document.close()
        return document.numberOfPages
    }

    private fun uploadToStorage(inputStream: InputStream, name: String) : String {

        val minioClient = MinioClient.builder()
                .endpoint("https://play.min.io")
                .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                .build()

        val isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket("bv-app-bucket").build())
        if (!isExist) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("bv-app-bucket").build())
        }

        minioClient.putObject(
                PutObjectArgs.builder().bucket("bv-app-bucket").`object`(name).stream(inputStream, -1, 10485760)
                .contentType("jpg")
                .build())

        val url = minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket("bv-app-bucket")
                        .`object`(name)
                        .expiry(24, TimeUnit.HOURS)
                        .build())

        return url
    }
}