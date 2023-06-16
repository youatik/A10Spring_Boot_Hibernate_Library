package com.example.a10spring_boot_hibernate_library.repository;

import com.example.a10spring_boot_hibernate_library.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository <Library, Long> {
    // You can add custom query methods here if needed
    List<Library> findByPublisherInAndDescriptionContaining(List<String> publishers, String searchTerm);
    List<Library> findByTitleContainingOrDescriptionContaining(String title, String description);
    List<Library> findByLengthLessThan(int maxLength);
    List<Library> findByLengthGreaterThan(int minLength);
    List<Library> findByLengthBetween(int minLength, int maxLength);

    List<Library> findByLengthLessThanAndDescriptionContaining(int maxLength, String searchTerm);

    List<Library> findByLengthGreaterThanAndDescriptionContaining(int maxLength, String searchTerm);

    void deleteByEanIsbn13(long eanIsbn13);

}

