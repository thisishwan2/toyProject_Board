package com.example.boardV1.board.service;

import com.example.boardV1.board.exception.NotHavePermissionBoardException;
import com.example.boardV1.board.model.Board;
import com.example.boardV1.board.repository.BoardRepository;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.service.UserFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardDeleteService {
    private final UserFindService userFindService;
    private final BoardRepository boardRepository;
    private final BoardFindService boardFindService;

    @Transactional
    public void deleteBoard(Long userId, Long boardId){
        User user = userFindService.findById(userId);
        Board board = boardFindService.findById(boardId);
        checkBoardLoginUser(user, board);
        boardRepository.deleteById(board.getBoard_id());
        //boardRepository.deleteById(boardId);
    }

    private void checkBoardLoginUser(User user, Board board) {
        if(!Objects.equals(board.getUser().getUser_id(), user.getUser_id())){
            throw new NotHavePermissionBoardException("해당 게시물을 삭제할 권한이 없습니다.");
        }
    }
}
