package com.ld.faststorage.controller;

import com.ld.faststorage.dto.DocumentDto;
import com.ld.faststorage.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;


    @PostMapping(value = "/document")
    public DocumentDto createDocument(@RequestBody DocumentDto documentDto) {
        return documentService.createDocument(documentDto);
    }

    @GetMapping("/document/{documentId}")
    public DocumentDto readDocumentById(@PathVariable("documentId") String documentId) {
        return documentService.readDocumentById(documentId);
    }

    @GetMapping("/document/all")
    public List<DocumentDto> readAllDocuments() {
        return documentService.readAllDocuments();
    }

    @GetMapping("/document/search")
    public List<DocumentDto> readAllDocumentsByTags(@RequestParam List<String> tagList) {
        return documentService.readAllDocumentsByTags(tagList);
    }

    @PutMapping(value = "/item/{documentId}/update")
    public DocumentDto updateDocumentById(@PathVariable("documentId") String documentId, @RequestBody DocumentDto documentDto) {
        return documentService.updateDocumentById(documentId, documentDto);
    }

    @DeleteMapping("/item/{documentId}/delete")
    public String deleteDocumentById(@PathVariable("userId") String documentId) {
        return documentService.deleteDocumentById(documentId);
    }

}