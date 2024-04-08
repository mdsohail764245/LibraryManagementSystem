package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookauthors")
public class BookAuthorsMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    Books books;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    Authors authors;

}
