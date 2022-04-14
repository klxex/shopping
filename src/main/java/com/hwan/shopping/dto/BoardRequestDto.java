package com.hwan.shopping.dto;

import com.hwan.shopping.domain.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
public class BoardRequestDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private int count;

    @Builder
    public BoardRequestDto(Long id, String title, String content, String author, int count) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.count = count;
    }

    public Board toEntity(){
        return  Board.builder()
                .title(this.title)
                .content(this.content)
                .author(this.author)
                .count(this.count)
                .build();
    }
}
