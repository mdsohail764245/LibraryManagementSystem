package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")
public class Members {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID member_id;
    private String name;
    private String address;
    private long phone;
    private String email;

}
