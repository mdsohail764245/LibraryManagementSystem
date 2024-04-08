package com.example.repo;

import com.example.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TransactionsRepo extends JpaRepository<Transactions, UUID> {



    @Query (value = "select * from Transactions t where t.book_id=:bookId and t.member_id=:memberId ",nativeQuery = true)
    Transactions findByBookIdAndMemId(UUID bookId, UUID memberId);

    @Query(value = "select * from Transactions t where t.member_id=:id ",nativeQuery = true)
    List<Transactions> findByUserId(UUID id);


    @Query(value = "select * from Transactions t where t.book_id=:id ",nativeQuery = true)
    List<Transactions> findByBookId(UUID id);

}
