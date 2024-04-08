package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Books {
    @Id
    private UUID book_id;
    private String title;
    private String author;
    private long isbn;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "genre_id")
//    Genres genres;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "genre_id")
        Genres genres;

    private int public_year;
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "public_id")
    Publishers publishers;

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", genres =" + genres +
                ", public_year=" + public_year +
                ", quantity=" + quantity +
                ", publishers=" + publishers +
                '}';
    }
}
