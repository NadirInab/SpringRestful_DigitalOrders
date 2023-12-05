package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.Contract;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
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
        Double price = devis.getDemande().getEquipement().getDailyRentalCost();
        Double discount = devis.getDiscount();
        Double priceAfter = discount == 0 ? price : (price) - (price * discount) / 100;

        return generatePdf(document -> {
            try {
                Paragraph header = new Paragraph("Devis - Quotation");
                document.add(header);

                document.add(new LineSeparator());

                document.add(new Paragraph("Devis ID: " + devis.getId()));
                document.add(new Paragraph("Date of creation: " + devis.getDateCreation()));
                document.add(new Paragraph("Date of expiration: " + devis.getDateExpiration()));
                document.add(new Paragraph("Demande ID: " + devis.getDemande().getId()));
                document.add(new Paragraph("Equipement: " + devis.getDemande().getEquipement().getName()));

                document.add(new Paragraph());

                Paragraph totalPrice = new Paragraph("Total Price: $" + String.format("%.2f", priceAfter));
                document.add(totalPrice);

                Paragraph footer = new Paragraph("Thank you for choosing our services!");
                document.add(footer);

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