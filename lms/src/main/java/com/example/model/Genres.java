package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "genres")
public class Genres {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID genre_id;
    private String genre_name;

    @Override
    public String toString() {
        return "Genres{" +
                "genre_id=" + genre_id +
                ", genre_name='" + genre_name + '\'' +
                '}';
    }
}
