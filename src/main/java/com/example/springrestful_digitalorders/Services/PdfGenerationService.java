package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.Contract;
import com.itextpdf.text.*;
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
                Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
                Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
                Font boldFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
                document.add(new Paragraph("Contract ID: " + contract.getId(), titleFont));
                document.add(new Paragraph("Devis ID: " + contract.getDevis().getId(), boldFont));
                document.add(new Paragraph("Is Archived: " + contract.getIsArchived(), normalFont));
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