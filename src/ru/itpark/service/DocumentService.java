package ru.itpark.service;

import ru.itpark.domain.Document;
import ru.itpark.repository.DocumentRepository;

public class DocumentService {
    private DocumentRepository repository;

    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }
    public void add(Document document){
        repository.add(document);
    }
    public Document getById(int id){
        return repository.getById(id);
    }
}
