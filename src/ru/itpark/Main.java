package ru.itpark;

import ru.itpark.domain.Document;
import ru.itpark.domain.User;
import ru.itpark.exception.InvalidPasswordException;
import ru.itpark.exception.NoSuchUserException;
import ru.itpark.exception.PermissionNotGrantedException;
import ru.itpark.repository.DocumentRepository;
import ru.itpark.repository.SecurityRepository;
import ru.itpark.service.DocumentService;
import ru.itpark.service.LibraryService;
import ru.itpark.service.SecurityService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User vasya = new User(1, "vasya", "vasya", List.of("S", "SS"));
        User masha = new User(2, "masha", "masha", List.of("S"));
        SecurityRepository securityRepository = new SecurityRepository();
        securityRepository.add(vasya);
        securityRepository.add(masha);
        Document secretDoc = new Document(1, "Secret Doc", "S");
        Document topSercretDoc = new Document(2, " Top secret Doc", "SS");
        DocumentRepository documentRepository = new DocumentRepository();
        documentRepository.add(secretDoc);
        documentRepository.add(topSercretDoc);
        SecurityService securityService = new SecurityService(securityRepository);
        DocumentService documentService = new DocumentService(documentRepository);
        LibraryService libraryService = new LibraryService(documentService, securityService);
        Document top = libraryService.getDocument(vasya.getLogin(), vasya.getPassword(), topSercretDoc.getId());
        Document secret = libraryService.getDocument(masha.getLogin(), masha.getPassword(), secretDoc.getId());
        try {
            libraryService.getDocument("hacker", vasya.getPassword(), topSercretDoc.getId());
        } catch (NoSuchUserException e){
            System.out.println("Нет такого пользователя");
        }
        try {
            libraryService.getDocument(vasya.getLogin(), "password", topSercretDoc.getId());
        } catch (InvalidPasswordException e){
            System.out.println("Неверный  пароль");
        }
        try {
            libraryService.getDocument(masha.getLogin(), masha.getPassword(), topSercretDoc.getId());
        } catch (PermissionNotGrantedException e){
            System.out.println("Недостаточно прав");
        }
    }
}
