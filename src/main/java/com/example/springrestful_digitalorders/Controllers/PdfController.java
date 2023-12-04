package com.example.springrestful_digitalorders.Controllers;

import com.example.springrestful_digitalorders.Repositories.ContractRepository;
import com.example.springrestful_digitalorders.entities.Contract;
import com.example.springrestful_digitalorders.entities.Devis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springrestful_digitalorders.Services.PdfGenerationService;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private final PdfGenerationService pdfGenerationService;
    private final ContractRepository contractRepository;

    @Autowired
    public PdfController(PdfGenerationService pdfGenerationService,
                         ContractRepository contractRepository) {
        this.pdfGenerationService = pdfGenerationService;
        this.contractRepository = contractRepository;
    }

    @GetMapping(value = "/contract/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateContractPdf(@PathVariable Long id) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new RuntimeException("Contract not found"));
        byte[] pdfBytes = pdfGenerationService.generateContractPdf(contract);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "contract.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/devis/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateDevisPdf(@PathVariable Long id) {
        Devis devis = new Devis();
        byte[] pdfBytes = pdfGenerationService.generateDevisPdf(devis);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "devis.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}
