package com.example.repo;

import com.example.model.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublicationRepo extends JpaRepository<Publishers, UUID> {

    @Query(value = "select * from Publishers p where p.name=:Name ",nativeQuery = true)
    Publishers findByPublisherName(String Name);
}
