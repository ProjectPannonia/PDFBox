import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PdfGenerator {
    public static void main(String[] args) throws IOException {
        String path = "D:\\PDF converter tests\\conversion\\bab.pdf";
        OutputStream stream = new FileOutputStream(path);
        generate(stream,"ŰÁÚŐ");
    }
    public static void generate(OutputStream stream, String s) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try {
            PDPageContentStream content = new PDPageContentStream(document, page);
            PDFont sans = PDType0Font.load(document, new File("D:\\PDF converter tests\\DejaVuLGCSansMono.ttf"));
            PDResources res = new PDResources();
            COSName fontName = res.add(sans);
            content.beginText();
            content.newLineAtOffset(25, 700);
            content.setLeading(14.5f);
            content.setFont(sans, 12);
            content.showText(s);
            //content.newLine();

//            PDFont serif = PDType0Font.load(document, PdfGenerator.class.getResourceAsStream("/ttf/DejaVuLGCSerif.ttf"));
//            content.setFont(serif, 12);
//            content.showText(s);
//            content.newLine();
//
//            PDFont mono = PDType0Font.load(document, PdfGenerator.class.getResourceAsStream("/ttf/DejaVuLGCSansMono.ttf"));
//            content.setFont(mono, 12);
            //content.showText(s);

            content.endText();
            content.close();

            document.save(stream);
            document.close();
        } catch (IOException e) {
            throw new IllegalStateException("Error creating pdf.", e);
        }
    }
}
