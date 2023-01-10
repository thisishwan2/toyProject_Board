package com.example.boardV1.board.service;

import com.example.boardV1.board.exception.NotFoundBoardException;
import com.example.boardV1.board.model.Board;
import com.example.boardV1.board.model.BoardCategory;
import com.example.boardV1.board.repository.BoardRepository;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.service.UserFindService;
import com.google.api.gax.rpc.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardFindService {

    private final BoardRepository boardRepository;
    private final UserFindService userFindService;

    public Board findById(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundBoardException(String.format("Board is not found!")));
        return board;
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public List<Board> findByCategory(BoardCategory category){
        return boardRepository.findByCategory(category);
    }

    public List<Board> findByUser(Long userId){
        User user = userFindService.findById(userId);
        return boardRepository.findByUser(user);
    }


}
