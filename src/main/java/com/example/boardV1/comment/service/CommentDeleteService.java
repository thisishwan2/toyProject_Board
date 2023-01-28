package com.example.boardV1.comment.service;

import com.example.boardV1.comment.Model.Comment;
import com.example.boardV1.comment.repository.CommentReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentDeleteService {

    private final CommentFindService commentFindService;
    private final CommentReposiroty commentReposiroty;

    @Transactional
    public void deleteComment(Long userId, Long boardId){
        Comment comment = commentFindService.findCommentByUserAndBoard(userId, boardId);
        commentReposiroty.deleteById(comment.getComment_id());
    }
}
