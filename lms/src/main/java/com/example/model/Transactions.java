package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transactions {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID trans_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    Books books;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    Members members;

    private String trans_type;
    LocalDate due_date;
    LocalDate return_date;

    public Transactions(Books books, Members members, String trans_type, LocalDate due_date, LocalDate return_date) {
        this.books = books;
        this.members = members;
        this.trans_type = trans_type;
        this.due_date = due_date;
        this.return_date = return_date;
    }
}
