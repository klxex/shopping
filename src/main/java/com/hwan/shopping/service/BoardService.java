package com.hwan.shopping.service;

import com.hwan.shopping.domain.Board;
import com.hwan.shopping.dto.BoardRequestDto;
import com.hwan.shopping.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> getBoard(Pageable pageable){

        return boardRepository.findAll(pageable);
    }

    public void add(BoardRequestDto boardRequestDto){
        boardRepository.save(boardRequestDto.toEntity());
    }

    public void update(BoardRequestDto boardRequestDto){
        Optional<Board> board= boardRepository.findById(boardRequestDto.getId());

        board.ifPresent(board1->{
            board1.setContent(boardRequestDto.getContent());
            board1.setTitle(boardRequestDto.getTitle());
            boardRepository.save(board1);
        });
    }

    public void delete(Long id){
        Optional<Board> board = boardRepository.findById(id);
        board.ifPresent(
                board1->{
                    boardRepository.delete(board1);
                }
        );
    }
}
