package com.example.boardV1.comment.api;

import com.example.boardV1.comment.service.CommentDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("comments/delete")
@RequiredArgsConstructor
@RestController
public class CommentDeleteApi {

    private final CommentDeleteService commentDeleteService;

    @DeleteMapping("/{userId}/{boardId}")
    public void deleteComment(@PathVariable Long userId, @PathVariable Long boardId){
        commentDeleteService.deleteComment(userId,boardId);
    }
}
