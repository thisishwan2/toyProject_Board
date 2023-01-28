package com.example.boardV1.comment.api;

import com.example.boardV1.comment.api.request.CommentUpdateRequest;
import com.example.boardV1.comment.service.CommentUpdateService;
import com.example.boardV1.util.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/commets/update")
@RequiredArgsConstructor
public class CommentUpdateApi {

    private final CommentUpdateService commentUpdateService;

    @PutMapping("/{userId}/{boardId}")
    public ApiResult<Long> updateComment(@PathVariable Long userId, @PathVariable Long boardId, @RequestBody CommentUpdateRequest commentUpdateRequest){
        try{
            return ApiResult.succeed(commentUpdateService.updateComment(userId, boardId, commentUpdateRequest));
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }
}
