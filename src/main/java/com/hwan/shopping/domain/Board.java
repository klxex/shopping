package com.hwan.shopping.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    private String content;
    private String author;
    private int count;

    @Builder
    public Board(String title, String content, String author, int count) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.count = count;
    }
}
