package com.example.springrestful_digitalorders.Services;

import com.example.springrestful_digitalorders.entities.Contract;
import com.itextpdf.text.*;
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
        Double price = devis.getDemande().getEquipement().getDailyRentalCost();
        Double discount = devis.getDiscount();
        Double priceAfter = discount == 0 ? price : (price) - (price * discount) / 100;

        return generatePdf(document -> {
            try {
                // Add a professional header
                Paragraph header = new Paragraph("Devis - Quotation");
                document.add(header);

                // Add a horizontal line for separation
                document.add(new LineSeparator());

                // Add details in a structured manner
                document.add(new Paragraph("Devis ID: " + devis.getId()));
                document.add(new Paragraph("Date of creation: " + devis.getDateCreation()));
                document.add(new Paragraph("Date of expiration: " + devis.getDateExpiration()));
                document.add(new Paragraph("Demande ID: " + devis.getDemande().getId()));
                document.add(new Paragraph("Equipement: " + devis.getDemande().getEquipement().getName()));

                // Add a line break
                document.add(new Paragraph());

                // Format total price
                Paragraph totalPrice = new Paragraph("Total Price: $" + String.format("%.2f", priceAfter));
                document.add(totalPrice);

                // Add a footer
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