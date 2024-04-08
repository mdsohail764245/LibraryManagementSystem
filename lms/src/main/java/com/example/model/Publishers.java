package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publishers")
public class Publishers {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID public_id;

    @Override
    public String toString() {
        return "Publishers{" +
                "public_id=" + public_id +
                ", name='" + name + '\'' +
                '}';
    }

    private String name;

}
