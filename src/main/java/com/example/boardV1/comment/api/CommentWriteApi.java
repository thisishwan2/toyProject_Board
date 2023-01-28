package com.example.boardV1.comment.api;

import com.example.boardV1.comment.api.request.CommentWriteRequest;
import com.example.boardV1.comment.service.CommentWriteService;
import com.example.boardV1.util.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comments") //comments/write 붙혀쓰는거랑 아래처럼 한거 차이가 있나?
public class CommentWriteApi {
    private final CommentWriteService commentWriteService;

    @PostMapping("/write/{userId}/{boardId}")
    public ApiResult<Long> writeComment(@PathVariable Long userId, @PathVariable Long boardId, @RequestBody CommentWriteRequest commentWriteRequest){
        try{
            return ApiResult.succeed(commentWriteService.writeComment(userId,boardId,commentWriteRequest));
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }
}
