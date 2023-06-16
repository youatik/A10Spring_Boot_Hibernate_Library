package com.example.a10spring_boot_hibernate_library.services;

import com.example.a10spring_boot_hibernate_library.entities.Library;
import com.example.a10spring_boot_hibernate_library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getAllBooks() {
        return libraryRepository.findAll();
    }

    public Optional<Library> getBookByEanIsbn13(long eanIsbn13) {
        return libraryRepository.findById(eanIsbn13);
    }

    public Library createBook(Library book) {
        return libraryRepository.save(book);
    }

    public void updateBook(Library book) {
        libraryRepository.save(book);
    }


    public List<Library> searchBooksByPublishersAndDescription(String searchTerm, List<String> publishers) {
        return libraryRepository.findByPublisherInAndDescriptionContaining(publishers, searchTerm);
    }

    public List<Library> searchBooksByTitleAndDescription(String searchTerm) {
        return libraryRepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    public List<Library> searchBooksByLengthLessThan(int maxLength) {
        return libraryRepository.findByLengthLessThan(maxLength);
    }

    public List<Library> searchBooksByLengthGreaterThan(int minLength) {
        return libraryRepository.findByLengthGreaterThan(minLength);
    }

    public List<Library> searchBooksByLengthBetween(int minLength, int maxLength) {
        return libraryRepository.findByLengthBetween(minLength, maxLength);
    }

    public void deleteBookByEanIsbn13(long eanIsbn13) {
        libraryRepository.deleteById(eanIsbn13);
    }
}
