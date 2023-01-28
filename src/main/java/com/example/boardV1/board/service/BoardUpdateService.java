package com.example.boardV1.board.service;

import com.example.boardV1.board.api.request.BoardUpdateRequest;
import com.example.boardV1.board.exception.NotHavePermissionBoardException;
import com.example.boardV1.board.model.Board;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.service.UserFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BoardUpdateService {
    private final BoardFindService boardFindService;
    private final UserFindService userFindService;

    @Transactional
    public Long updateBoard(Long userId, Long boardId, BoardUpdateRequest boardUpdateRequest) {
        User user = userFindService.findById(userId);
        Board board = boardFindService.findById(boardId);
        checkBoardLoginUser(user,board);
        Long updateBoardId = board.update(
                boardUpdateRequest.getTitle(),
                boardUpdateRequest.getContent(),
                boardUpdateRequest.getCategory()
        );
        return updateBoardId;
    }

    private void checkBoardLoginUser(User user, Board board) {
        if(!Objects.equals(board.getUser().getUser_id(), user.getUser_id())){
            throw new NotHavePermissionBoardException("해당 게시물을 수정할 권한이 없습니다.");
        }
    }
}
