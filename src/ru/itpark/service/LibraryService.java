package ru.itpark.service;

import ru.itpark.domain.Document;

public class LibraryService {
    private DocumentService documentService;
    private SecurityService securityService;

    public LibraryService(DocumentService documentService, SecurityService securityService) {
        this.documentService = documentService;
        this.securityService = securityService;
    }
    public Document getDocument(String login, String password, int documentId){
        securityService.authenticate(login, password);
        Document document = documentService.getById(documentId);
        securityService.checkAccess(login, document.getMinPermission());
        return document;
    }
}
