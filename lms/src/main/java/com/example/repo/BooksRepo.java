package com.example.repo;

import com.example.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BooksRepo extends JpaRepository<Books, UUID> {

}
