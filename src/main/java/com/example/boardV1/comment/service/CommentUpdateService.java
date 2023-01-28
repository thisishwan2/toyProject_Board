package com.example.boardV1.comment.service;

import com.example.boardV1.comment.Model.Comment;
import com.example.boardV1.comment.api.request.CommentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentUpdateService {

    private final CommentFindService commentFindService;

    @Transactional
    public Long updateComment(Long userId, Long boardId, CommentUpdateRequest commentUpdateRequest){
        Comment comment = commentFindService.findCommentByUserAndBoard(userId, userId);
        return comment.update(commentUpdateRequest.getContent());
    }
}
