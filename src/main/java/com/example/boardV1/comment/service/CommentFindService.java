package com.example.boardV1.comment.service;

import com.example.boardV1.board.model.Board;
import com.example.boardV1.board.service.BoardFindService;
import com.example.boardV1.comment.Model.Comment;
import com.example.boardV1.comment.exception.NotFoundCommentException;
import com.example.boardV1.comment.repository.CommentReposiroty;
import com.example.boardV1.user.model.User;
import com.example.boardV1.user.service.UserFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentFindService {
    private final UserFindService userFindService;
    private final BoardFindService boardFindService;
    private final CommentReposiroty commentReposiroty;

    @Transactional(readOnly = true)
    public List<Comment> findAllCommentsInBoard(Long boardId){
        Board board = boardFindService.findById(boardId);
        return commentReposiroty.findCommentByBoard(board);
    }

    @Transactional(readOnly = true)
    public Comment findCommentByUserAndBoard(Long userId, Long boardId){
        User user = userFindService.findById(userId);
        Board board = boardFindService.findById(boardId);
        return commentReposiroty.findByUserAndBoard(user,board)
                .orElseThrow(()-> new NotFoundCommentException(String.format("코멘트가 없습니다.")));
    }
}
