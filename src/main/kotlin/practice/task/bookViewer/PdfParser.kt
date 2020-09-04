package practice.task.bookViewer

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.rendering.ImageType
import org.apache.pdfbox.rendering.PDFRenderer
import java.io.File
import java.io.InputStream
import javax.imageio.ImageIO

object PdfParser {

    fun parse(fis: InputStream, name: String?, isbn: String): Int {

        val document: PDDocument = PDDocument.load(fis)
        val pdfRenderer = PDFRenderer(document)
        for (page in 0 until document.numberOfPages) {
            GlobalScope.launch {
                val bImage = pdfRenderer.renderImageWithDPI(page, 300f, ImageType.RGB)

//            var imageFile = File("D:\\PDF\\" + name +"_"+ (page + 1) + ".jpg")
//            ImageIO.write(bImage, ".jpg", imageFile)

                ImageIO.write(bImage, "jpg", File("C://Users//Yura//Desktop//PDF//" + name + "_" + (page + 1) + ".jpg"));
            }
//            pageRepository.save(Page(
//                    isbn = isbn,
//                    number = page + 1,
//                    url = ""
//            ))
        }
        //document.close()
        return document.numberOfPages
    }
}