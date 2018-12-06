package ru.itpark.repository;

import ru.itpark.domain.Document;
import ru.itpark.exception.NoSuchDocumentException;

import java.util.ArrayList;
import java.util.List;

public class DocumentRepository {
    private List<Document> documents = new ArrayList<>();

    public void add(Document document) {
        documents.add(document);
    }

    public Document getById(int id) {
        for (Document document : documents) {
            if (document.getId() == id) {
                return document;
            }
        }
        throw new NoSuchDocumentException();
    }
}
