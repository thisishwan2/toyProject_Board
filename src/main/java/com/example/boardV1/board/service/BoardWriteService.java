package com.example.boardV1.board.service;

import com.example.boardV1.board.api.request.BoardWriteRequest;
import com.example.boardV1.board.model.Board;
import com.example.boardV1.board.repository.BoardRepository;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.service.UserFindService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BoardWriteService {

    private final BoardRepository boardRepository;
    private final UserFindService userFindService;

    @Transactional
    public Long writeBoard(Long userId, BoardWriteRequest boardWriteRequest){
        User user = userFindService.findById(userId);
        Board board = Board.builder()
                .title(boardWriteRequest.getTitle())
                .content(boardWriteRequest.getContent())
                .writer(user.getName())
                .category(boardWriteRequest.getCategory())
                .build();
        Board savedBoard = boardRepository.save(board);
        user.writeBoard(savedBoard);
        return board.getBoard_id();
    }
}
