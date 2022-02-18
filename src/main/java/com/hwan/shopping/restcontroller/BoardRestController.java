package com.hwan.shopping.restcontroller;

import com.hwan.shopping.domain.Board;
import com.hwan.shopping.dto.BoardResponseDto;
import com.hwan.shopping.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardRestController {
    private final BoardService boardService;
    @GetMapping("/boards")
    public List<BoardResponseDto> readBoard(@PageableDefault(size=7) Pageable pageable){
        Page<Board> boards =  boardService.getBoard(pageable);
        List<Board> list = boards.getContent();
        List<BoardResponseDto> lists = new LinkedList<>();
        for(Board board:list){
            lists.add(BoardResponseDto.builder()
                    .title(board.getTitle())
                    .id(board.getId())
                    .author(board.getAuthor())
                    .count(board.getCount())
                    .build());
        }
        return lists;
    }
    @PostMapping("/boards")
    public void createBoard(@RequestBody Board board){

    }

    @PutMapping("/boards/{id}")
    public void updateBoard(){

    }
    @DeleteMapping("/boards/{id}")
    public void removeBoard(){

    }


}
