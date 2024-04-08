package com.example.repo;

import com.example.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MembersRepo extends JpaRepository<Members, UUID> {

}
