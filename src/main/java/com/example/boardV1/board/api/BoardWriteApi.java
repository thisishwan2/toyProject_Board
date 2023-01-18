package com.example.boardV1.board.api;

import com.example.boardV1.board.api.request.BoardWriteRequest;
import com.example.boardV1.board.service.BoardWriteService;
import com.example.boardV1.util.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardWriteApi {

    private final BoardWriteService boardWriteService;

    @PostMapping("/{userId}/write")
    public ApiResult<Long> writeBoard(@PathVariable Long userId,
                                      @RequestBody BoardWriteRequest boardWriteRequest){
        try{
            Long boardId = boardWriteService.writeBoard(userId, boardWriteRequest);
            return ApiResult.succeed(boardId);
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResult.failed(e.getMessage());
        }
    }
}
