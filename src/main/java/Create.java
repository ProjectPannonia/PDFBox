import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public class Create {
    public static void create(String path) {
        try {
            PDDocument doc = new PDDocument();
            doc.save(path);
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
