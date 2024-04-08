package com.example.model;

import lombok.Data;

import java.util.UUID;

@Data
public class BookRequest {
    private UUID book_id;
    private UUID member_id;
    private String trans_type;
}
