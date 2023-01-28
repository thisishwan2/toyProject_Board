package com.example.boardV1.board.service;

import com.example.boardV1.board.exception.NotFoundBoardException;
import com.example.boardV1.board.model.Board;
import com.example.boardV1.board.model.BoardCategory;
import com.example.boardV1.board.repository.BoardRepository;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.service.UserFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardFindService {

    private final BoardRepository boardRepository;
    private final UserFindService userFindService;

    @Transactional(readOnly = true)
    public Board findById(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundBoardException(String.format("Board is not found!")));
        return board;
    }

    @Transactional(readOnly = true)
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Board> findByCategory(BoardCategory category){
        return boardRepository.findByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Board> findByUser(Long userId){
        User user = userFindService.findById(userId);
        return boardRepository.findByUser(user);
    }
}
