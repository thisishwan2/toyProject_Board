package com.example.boardV1.comment.api;

import com.example.boardV1.comment.Model.Comment;
import com.example.boardV1.comment.service.CommentFindService;
import com.example.boardV1.util.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentFindApi {

    private final CommentFindService commentFindService;

    @GetMapping("/{boardId")
    public ApiResult<List<Comment>> findComments(@PathVariable Long boardId){
        try{
            return ApiResult.succeed(commentFindService.findAllCommentsInBoard(boardId));
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }
}
