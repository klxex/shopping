package com.hwan.shopping.restcontroller;

import com.hwan.shopping.domain.Board;
import com.hwan.shopping.dto.BoardRequestDto;
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
    public List<BoardResponseDto> readBoard(@PageableDefault(size=7,sort = "id") Pageable pageable){
        Page<Board> boards =  boardService.getAllBoard(pageable);
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

    @GetMapping("/boards/{id}")
    public Board  getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    @PostMapping("/boards")
    public void createBoard(@RequestBody BoardRequestDto boardRequestDto){
        boardService.add(boardRequestDto);
    }

    @PutMapping("/boards/{id}")
    public void updateBoard(@RequestBody BoardRequestDto boardRequestDto){
        boardService.update(boardRequestDto);
    }

    @DeleteMapping("/boards/{id}")
    public void removeBoard(@PathVariable Long id){
        boardService.delete(id);
    }


}
