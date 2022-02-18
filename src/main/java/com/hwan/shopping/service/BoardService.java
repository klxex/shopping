package com.hwan.shopping.service;

import com.hwan.shopping.domain.Board;
import com.hwan.shopping.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> getBoard(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

}
