package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.Contract;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import com.example.springrestful_digitalorders.entities.Devis;

@Service
public class PdfGenerationService {

    public byte[] generateContractPdf(Contract contract) {
        return generatePdf(document -> {
            try {
                document.add(new Paragraph("Contract ID: " + contract.getId()));
                document.add(new Paragraph("Devis ID: " + contract.getDevis().getId()));
                document.add(new Paragraph("Is Archived: " + contract.getIsArchived()));
            } catch (DocumentException e) {
                throw new RuntimeException("Error adding content to PDF", e);
            }
        });
    }

    public byte[] generateDevisPdf(Devis devis) {
        return generatePdf(document -> {
            try {
                document.add(new Paragraph("Devis ID: " + devis.getId()));
            } catch (DocumentException e) {
                throw new RuntimeException("Error adding content to PDF", e);
            }
        });
    }

    private byte[] generatePdf(PdfContentProvider contentProvider) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();
            contentProvider.provideContent(document);
            document.close();
            return outputStream.toByteArray();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }

    interface PdfContentProvider {
        void provideContent(Document document) throws DocumentException;
    }
}