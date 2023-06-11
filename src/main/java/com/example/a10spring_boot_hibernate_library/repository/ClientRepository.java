package com.example.a10spring_boot_hibernate_library.repository;

import com.example.a10spring_boot_hibernate_library.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Custom queries or additional methods can be defined here if needed
}

