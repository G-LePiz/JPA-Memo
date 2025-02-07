package com.example.jpa1.dto;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;

@Getter
public class MemoRequestDto {

    private String title;

    private String content;
}
