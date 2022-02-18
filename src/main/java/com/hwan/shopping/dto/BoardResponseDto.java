package com.hwan.shopping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String author;
    private int count;


    @Builder
    public BoardResponseDto(Long id, String title, String author, int count) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.count = count;
    }
}
