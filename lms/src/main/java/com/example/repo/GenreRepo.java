package com.example.repo;

import com.example.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepo extends JpaRepository<Genres, UUID> {
    @Query(value = "select * from Genres g where g.genre_name=:genreName ", nativeQuery = true)
    Genres findByGenreName(String genreName);
}
