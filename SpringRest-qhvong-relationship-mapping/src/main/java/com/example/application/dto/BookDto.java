package com.example.application.dto;

import lombok.Data;

@Data
public class BookDto {
    private String description;
    private String name;
    private Long category_id;
}
