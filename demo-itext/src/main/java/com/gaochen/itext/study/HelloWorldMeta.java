package com.gaochen.itext.study;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/11/1
 * Generates a PDF file with metadata
 */
public class HelloWorldMeta {
    public static void main(String[] args) {
        System.out.println("Metadata");
        // step 1: creation of a document-object
        Document document = new Document();
        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            PdfWriter.getInstance(document,
                    new FileOutputStream("HelloWorldMeta.pdf"));
            // step 3: we add some metadata open the document
            document.addTitle("Hello World example");
            document.addSubject("This example explains how to add metadata.");
            document.addKeywords("iText, Hello World, step 3,metadata");
            document.addCreator("My program using iText");
            document.addAuthor("Bruno Lowagie");
            document.open();
            // step 4: we add a paragraph to the document
            document.add(new Paragraph("Hello World"));
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
        // step 5: we close the document
        document.close();
    }
}
