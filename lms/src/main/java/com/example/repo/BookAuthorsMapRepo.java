package com.example.repo;

import com.example.model.BookAuthorsMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorsMapRepo extends JpaRepository<BookAuthorsMap,Integer> {

}
