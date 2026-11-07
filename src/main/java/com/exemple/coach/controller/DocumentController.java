package com.exemple.coach.controller;
import com.exemple.coach.dto.IngestionRequest;
import com.exemple.coach.dto.IngestionResponse;
import com.exemple.coach.service.DocumentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
    @PostMapping
    public IngestionResponse ingerer(@Valid @RequestBody IngestionRequest requete) {
        return documentService.ingerer(requete.theme(), requete.texte());
    }
}