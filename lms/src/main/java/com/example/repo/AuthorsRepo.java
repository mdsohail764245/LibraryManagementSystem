package com.example.repo;

import com.example.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AuthorsRepo extends JpaRepository<Authors, UUID> {

    @Query(value = "select * from Authors a where a.author_name=:author ",nativeQuery = true)
    Authors findByAuthorName(String author);

}
